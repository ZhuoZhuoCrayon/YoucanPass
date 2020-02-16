package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.common.constant.CmsOpenCourseConstant;
import com.crayon.youcanpass.common.exception.ServiceException;
import com.crayon.youcanpass.common.impl_sys.UserDetailsImpl;
import com.crayon.youcanpass.component.SecurityUserHelper;
import com.crayon.youcanpass.dao.CmsOpenCourseDao;
import com.crayon.youcanpass.dto.CmsOpenCourseForUserParam;
import com.crayon.youcanpass.dto.CmsOpenCourseQuery;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import com.crayon.youcanpass.mapper.CmsOpencourseMapper;
import com.crayon.youcanpass.model.CmsCourse;
import com.crayon.youcanpass.model.CmsOpencourse;
import com.crayon.youcanpass.model.CmsOpencourseExample;
import com.crayon.youcanpass.model.ImsSemester;
import com.crayon.youcanpass.service.CmsCourseService;
import com.crayon.youcanpass.service.CmsOpenCourseService;
import com.crayon.youcanpass.service.ImsSemesterService;
import com.crayon.youcanpass.service.UmsUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CmsOpenCourseServiceImpl
 * @Description 开课管理Service实现层
 * @Date 2020/2/10 22:34
 * @Created by Crayon
 */
@Service
public class CmsOpenCourseServiceImpl implements CmsOpenCourseService {
    @Autowired
    private CmsOpencourseMapper opencourseMapper;
    @Autowired
    private CmsOpenCourseDao openCourseDao;
    @Autowired
    private CmsCourseService courseService;
    @Autowired
    private ImsSemesterService imsSemesterService;
    @Autowired
    private UmsUserService umsUserService;

    @Override
    public void checkParam(CmsOpenCourseForUserParam openCourseForUserParam) {
        CmsCourse course = courseService.get(openCourseForUserParam.getCourseId());
        if(course == null){
            throw ServiceException.failed("课程不存在");
        }
        ImsSemester semester = imsSemesterService.get(openCourseForUserParam.getSemesterId());
        if(semester == null){
            throw ServiceException.failed("学期信息不存在");
        }
    }

    @Override
    public CmsOpencourse get(Long id) {
        return opencourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CmsOpenCourseSimpleDto> listOpenCourseSimpleByQuery(CmsOpenCourseQuery openCourseQuery,
                                                                    Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return openCourseDao.listOpenCoursesByQuery(openCourseQuery);
    }

    @Override
    public int insertByLoginUser(CmsOpenCourseForUserParam openCourseForUserParam) {
        //深度校验参数
        checkParam(openCourseForUserParam);
        //获取用户id
        Long userId =  umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        CmsOpencourse opencourse = new CmsOpencourse();
        BeanUtils.copyProperties(openCourseForUserParam, opencourse);
        opencourse.setUserId(userId);       //设置用户
        opencourse.setSelectCount(0);       //初始化选课人数为0
        opencourse.setStatus(CmsOpenCourseConstant.WAITING_AUDIT);    //初始化状态为等待审核
        return opencourseMapper.insertSelective(opencourse);
    }

    @Override
    public int delete(Long id) {
        return opencourseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        CmsOpencourseExample opencourseExample = new CmsOpencourseExample();
        opencourseExample.createCriteria().andIdIn(ids);
        return opencourseMapper.deleteByExample(opencourseExample);
    }

    @Override
    public int update(Long id, CmsOpenCourseForUserParam openCourseForUserParam) {
        checkParam(openCourseForUserParam);
        CmsOpencourse opencourse = new CmsOpencourse();
        BeanUtils.copyProperties(openCourseForUserParam, opencourse);
        opencourse.setId(id);
        return opencourseMapper.updateByPrimaryKeySelective(opencourse);
    }

    @Override
    public int updateStatusBatch(List<Long> ids, Integer status, String statusComment) {
        CmsOpencourse opencourse = new CmsOpencourse();
        opencourse.setStatus(status);
        opencourse.setStatusComment(statusComment);
        CmsOpencourseExample opencourseExample = new CmsOpencourseExample();
        opencourseExample.createCriteria().andIdIn(ids);

        return opencourseMapper.updateByExampleSelective(opencourse, opencourseExample);
    }
}
