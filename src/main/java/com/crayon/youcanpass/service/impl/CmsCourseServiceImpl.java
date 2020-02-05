package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.mapper.CmsCourseMapper;
import com.crayon.youcanpass.model.CmsCourse;
import com.crayon.youcanpass.model.CmsCourseExample;
import com.crayon.youcanpass.service.CmsCourseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CmsCourseServiceImpl
 * @Description 课程管理Service接口实现层
 * @Date 2020/2/5 20:19
 * @Created by Crayon
 */
@Service
public class CmsCourseServiceImpl implements CmsCourseService {
    @Autowired
    private CmsCourseMapper courseMapper;
    @Override
    public List<CmsCourse> listByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return courseMapper.selectByExample(new CmsCourseExample());
    }

    @Override
    public CmsCourse get(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CmsCourse> list() {
        return courseMapper.selectByExample(new CmsCourseExample());
    }

    @Override
    public int insert(CmsCourse cmsCourse) {
        cmsCourse.setId(null);
        return courseMapper.insertSelective(cmsCourse);
    }

    @Override
    public int delete(Long id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, CmsCourse cmsCourse) {
        cmsCourse.setId(id);
        return courseMapper.updateByPrimaryKeySelective(cmsCourse);
    }
    @Override
    public int updateStatusBatch(List<Long> ids, Integer status) {
        CmsCourse course = new CmsCourse();
        CmsCourseExample courseExample = new CmsCourseExample();
        courseExample.createCriteria().andIdIn(ids);
        course.setStatus(status);
        return courseMapper.updateByExampleSelective(course, courseExample);
    }

    @Override
    public int updateTermBatch(List<Long> ids, Integer term) {
        CmsCourse course = new CmsCourse();
        CmsCourseExample courseExample = new CmsCourseExample();
        courseExample.createCriteria().andIdIn(ids);
        course.setTerm(term);
        return courseMapper.updateByExampleSelective(course, courseExample);
    }

    @Override
    public int updateTypeBatch(List<Long> ids, Integer type) {
        CmsCourse course = new CmsCourse();
        CmsCourseExample courseExample = new CmsCourseExample();
        courseExample.createCriteria().andIdIn(ids);
        course.setStatus(type);
        return courseMapper.updateByExampleSelective(course, courseExample);
    }
}
