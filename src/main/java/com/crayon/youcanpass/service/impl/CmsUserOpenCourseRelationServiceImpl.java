package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.common.constant.CmsUserOpenCourseRelationConstant;
import com.crayon.youcanpass.common.exception.ServiceException;
import com.crayon.youcanpass.component.SecurityUserHelper;
import com.crayon.youcanpass.dao.CmsOpenCourseRelationDao;
import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationDto;
import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationQuery;
import com.crayon.youcanpass.mapper.CmsOpencourseMapper;
import com.crayon.youcanpass.mapper.CmsUserOpencourseRelationMapper;
import com.crayon.youcanpass.model.CmsOpencourse;
import com.crayon.youcanpass.model.CmsUserOpencourseRelation;
import com.crayon.youcanpass.model.CmsUserOpencourseRelationExample;
import com.crayon.youcanpass.service.CmsUserOpenCourseRelationService;
import com.crayon.youcanpass.service.UmsUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CmsUserOpenCourseRelationServiceImpl
 * @Description 选课关系业务层实现类
 * @Date 2020/2/16 16:50
 * @Created by Crayon
 */
@Service
public class CmsUserOpenCourseRelationServiceImpl implements CmsUserOpenCourseRelationService {
    @Autowired
    private CmsUserOpencourseRelationMapper userOpencourseRelationMapper;
    @Autowired
    private CmsOpenCourseRelationDao courseRelationDao;
    @Autowired
    private CmsOpencourseMapper opencourseMapper;
    @Autowired
    private UmsUserService umsUserService;

    @Override
    public CmsUserOpencourseRelation get(Long id) {
        return userOpencourseRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CmsUserOpenCourseRelationDto> listByPageQuery(
            CmsUserOpenCourseRelationQuery userOpenCourseRelationQuery,
            Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return courseRelationDao.listCmsUserOpenCourseRelationDtoByQuery(userOpenCourseRelationQuery);
    }

    @Override
    public List<CmsUserOpenCourseRelationDto> listByQuery(CmsUserOpenCourseRelationQuery userOpenCourseRelationQuery) {
        return courseRelationDao.listCmsUserOpenCourseRelationDtoByQuery(userOpenCourseRelationQuery);
    }

    @Override
    public int select(Long opencourseId) {
        long userId = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        CmsOpencourse opencourse = opencourseMapper.selectByPrimaryKey(opencourseId);
        if(opencourse == null) throw ServiceException.failed("课程不存在");
        if(opencourse.getStatus() != 1) throw ServiceException.forbidden("课程不在可选状态");
        if(opencourse.getUserId() == userId) throw ServiceException.forbidden("不能选择自己的课程");

        CmsUserOpenCourseRelationQuery userOpenCourseRelationQuery = new CmsUserOpenCourseRelationQuery();
        userOpenCourseRelationQuery.setUsername(SecurityUserHelper.getLoginUserName());
        userOpenCourseRelationQuery.setCourseId(opencourse.getCourseId());

        // 查找该用户这门课的选课情况
        List<CmsUserOpenCourseRelationDto> selectCourseList =
                courseRelationDao.listCmsUserOpenCourseRelationDtoByQuery(userOpenCourseRelationQuery);
        for(CmsUserOpenCourseRelationDto relation : selectCourseList){
            if(relation.getStatus() != CmsUserOpenCourseRelationConstant.FAILED_AUDIT){
                if(relation.getOpencourseId().equals(opencourseId)){
                    throw ServiceException.forbidden("不能重复选择同一门课");
                }else {
                    throw ServiceException.forbidden("已选择[" + relation.getCourseName() + "]的其他课程");
                }
            }else{
                //已选择了这门课但审核不通过：禁止学生再次选择该课程
                if(relation.getOpencourseId().equals(opencourseId)){
                    throw ServiceException.forbidden("已选择该课程但审核不通过，请选择其他课程");
                }
            }
        }

        //选课人数+1
        opencourse.setSelectCount(opencourse.getSelectCount() + 1);
        opencourseMapper.updateByPrimaryKeySelective(opencourse);

        //选课
        CmsUserOpencourseRelation userOpencourseRelation = new CmsUserOpencourseRelation();
        userOpencourseRelation.setOpencourseId(opencourseId);
        userOpencourseRelation.setUserId(userId);
        userOpencourseRelation.setStatus(CmsUserOpenCourseRelationConstant.WAITING_AUDIT);
        userOpencourseRelation.setStatusComment("学生选课，等待管理员审核");
        return userOpencourseRelationMapper.insertSelective(userOpencourseRelation);
    }

    @Override
    public int delete(Long id) {
        long userId = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        CmsUserOpencourseRelation userOpencourseRelation = userOpencourseRelationMapper.selectByPrimaryKey(id);

        if(userOpencourseRelation == null || userOpencourseRelation.getUserId() != userId) {
            throw ServiceException.failed("选课信息不存在");
        }
        if(userOpencourseRelation.getStatus() != CmsUserOpenCourseRelationConstant.WAITING_AUDIT){
            throw ServiceException.forbidden("不在可退状态：[审核不通过]-请选择其他课程 | [其他状态]-不可退");
        }

        //选课人数-1
        CmsOpencourse opencourse = opencourseMapper.selectByPrimaryKey(userOpencourseRelation.getOpencourseId());
        opencourse.setSelectCount(opencourse.getSelectCount() - 1);
        opencourseMapper.updateByPrimaryKeySelective(opencourse);

        return userOpencourseRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        for(Long id : ids){
            CmsUserOpencourseRelation userOpencourseRelation = userOpencourseRelationMapper.selectByPrimaryKey(id);
            if(userOpencourseRelation == null) throw ServiceException.failed("选课信息不存在");
            CmsOpencourse opencourse = opencourseMapper.selectByPrimaryKey(userOpencourseRelation.getOpencourseId());
            if(opencourse == null) throw ServiceException.failed("开课信息不存在");

            int status = userOpencourseRelation.getStatus();
            /**
             * 删除的选课信息是审核通过及以上的状态，选课人数 -1
             */
            if(status != CmsUserOpenCourseRelationConstant.FAILED_AUDIT){
                opencourse.setSelectCount(opencourse.getSelectCount() - 1);
                opencourseMapper.updateByPrimaryKeySelective(opencourse);
            }
        }
        CmsUserOpencourseRelationExample userOpencourseRelationExample = new CmsUserOpencourseRelationExample();
        userOpencourseRelationExample.createCriteria().andIdIn(ids);
        return userOpencourseRelationMapper.deleteByExample(userOpencourseRelationExample);
    }

    @Override
    public int updateStatusBatch(List<Long> ids, Integer status, String statusComment) {
        int count = 0;
        for(Long id : ids){
            this.updateStatus(id, status, statusComment);
            count++;
        }
        return count;
    }

    @Override
    public int updateStatus(Long id, Integer status, String statusComment) {
        CmsUserOpencourseRelation userOpencourseRelation = userOpencourseRelationMapper.selectByPrimaryKey(id);
        int originStatus = userOpencourseRelation.getStatus();
        if(originStatus == status) throw ServiceException.failed("状态已存在");
        if(status == CmsUserOpenCourseRelationConstant.FAILED_AUDIT){
            if(originStatus != CmsUserOpenCourseRelationConstant.WAITING_AUDIT){
                throw ServiceException.failed("一旦审核通过，不能撤销");
            }else{
                /**
                 * 从待审核状态判定为审核失败，相应的选课人数-1
                 */
                CmsOpencourse opencourse = opencourseMapper.selectByPrimaryKey(userOpencourseRelation.getOpencourseId());
                opencourse.setSelectCount(opencourse.getSelectCount() - 1);
                opencourseMapper.updateByPrimaryKeySelective(opencourse);
            }
        }else{
            /**
             * 状态不得回退
             */
            if(originStatus > status){
                throw ServiceException.failed("状态不得回退");
            }
        }
        userOpencourseRelation.setStatusComment(statusComment);
        userOpencourseRelation.setStatus(status);
        userOpencourseRelation.setId(id);
        return userOpencourseRelationMapper.updateByPrimaryKeySelective(userOpencourseRelation);
    }
}
