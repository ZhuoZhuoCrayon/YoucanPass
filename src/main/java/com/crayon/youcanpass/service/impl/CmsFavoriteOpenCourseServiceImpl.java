package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.common.exception.ServiceException;
import com.crayon.youcanpass.dao.CmsFavoriteOpenCourseDao;
import com.crayon.youcanpass.dto.CmsFavoriteOpenCourseDto;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import com.crayon.youcanpass.mapper.CmsFavoriteOpencourseMapper;
import com.crayon.youcanpass.mapper.CmsOpencourseMapper;
import com.crayon.youcanpass.mapper.ImsSemesterMapper;
import com.crayon.youcanpass.model.CmsFavoriteOpencourse;
import com.crayon.youcanpass.model.CmsFavoriteOpencourseExample;
import com.crayon.youcanpass.model.CmsOpencourse;
import com.crayon.youcanpass.model.ImsSemester;
import com.crayon.youcanpass.service.CmsFavoriteOpenCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CmsFavoriteOpenCourseServiceImpl
 * @Description 收藏课程业务层实现
 * @Date 2020/2/27 16:38
 * @Created by Crayon
 */
@Service
public class CmsFavoriteOpenCourseServiceImpl implements CmsFavoriteOpenCourseService {
    @Autowired
    private CmsFavoriteOpencourseMapper favoriteOpencourseMapper;
    @Autowired
    private CmsFavoriteOpenCourseDao favoriteOpenCourseDao;
    @Autowired
    private CmsOpencourseMapper opencourseMapper;
    @Autowired
    private ImsSemesterMapper imsSemesterMapper;
    @Override
    public List<CmsFavoriteOpenCourseDto> list(Long userId, Long semesterId) {
        return favoriteOpenCourseDao.list(userId, semesterId);
    }

    @Override
    public CmsFavoriteOpencourse get(Long id) {
        return null;
    }

    @Override
    public List<CmsFavoriteOpencourse> list() {
        return null;
    }

    @Override
    public int insert(CmsFavoriteOpencourse cmsFavoriteOpencourse) {
        check(cmsFavoriteOpencourse);
        CmsFavoriteOpencourseExample favoriteOpencourseExample = new CmsFavoriteOpencourseExample();
        favoriteOpencourseExample
                .createCriteria()
                .andUserIdEqualTo(cmsFavoriteOpencourse.getUserId())
                .andOpencourseIdEqualTo(cmsFavoriteOpencourse.getOpencourseId());
        List<CmsFavoriteOpencourse> favoriteOpencourseList = favoriteOpencourseMapper.selectByExample(favoriteOpencourseExample);
        if(favoriteOpencourseList.size() > 0){
            throw ServiceException.failed("不能重复添加课程哦");
        }
        return favoriteOpencourseMapper.insertSelective(cmsFavoriteOpencourse);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(Long id, CmsFavoriteOpencourse cmsFavoriteOpencourse) {
        ImsSemester imsSemester = imsSemesterMapper.selectByPrimaryKey(cmsFavoriteOpencourse.getSemesterId());
        if(imsSemester == null){
            throw ServiceException.failed("学期信息不存在");
        }

        CmsFavoriteOpencourse origin = favoriteOpencourseMapper.selectByPrimaryKey(id);
        if(!origin.getUserId().equals(cmsFavoriteOpencourse.getUserId())){
            throw ServiceException.failed("收藏夹中没有该课程");
        }
        cmsFavoriteOpencourse.setId(id);
        return favoriteOpencourseMapper.updateByPrimaryKeySelective(cmsFavoriteOpencourse);
    }

    @Override
    public int delete(Long userId ,Long id) {
        CmsFavoriteOpencourseExample favoriteOpencourseExample = new CmsFavoriteOpencourseExample();
        //必须检查删除id是否存在于用户收藏夹
        favoriteOpencourseExample.createCriteria().andUserIdEqualTo(userId).andIdEqualTo(id);
        return favoriteOpencourseMapper.deleteByExample(favoriteOpencourseExample);
    }

    public void check(CmsFavoriteOpencourse cmsFavoriteOpencourse){
        CmsOpencourse opencourse = opencourseMapper.selectByPrimaryKey(cmsFavoriteOpencourse.getOpencourseId());
        ImsSemester imsSemester = imsSemesterMapper.selectByPrimaryKey(cmsFavoriteOpencourse.getSemesterId());
        if(opencourse == null){
            throw ServiceException.failed("开课信息不存在");
        }
        if(imsSemester == null){
            throw ServiceException.failed("学期信息不存在");
        }
    }
}
