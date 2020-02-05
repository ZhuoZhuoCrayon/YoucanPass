package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.common.constant.ImsConstant;
import com.crayon.youcanpass.dto.ImsSemesterParam;
import com.crayon.youcanpass.mapper.ImsSemesterMapper;
import com.crayon.youcanpass.model.ImsSemester;
import com.crayon.youcanpass.model.ImsSemesterExample;
import com.crayon.youcanpass.service.ImsSemesterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ImsSemesterServiceImpl
 * @Description 学期信息Service接口实现层
 * @Date 2020/2/5 15:33
 * @Created by Crayon
 */
@Service
public class ImsSemesterServiceImpl implements ImsSemesterService {

    @Autowired
    private ImsSemesterMapper semesterMapper;
    @Override
    public List<ImsSemester> listByTimeRange(Integer begin, Integer end) {
        ImsSemesterExample semesterExample = new ImsSemesterExample();
        semesterExample.createCriteria().andBeginYearBetween(begin, end);
        return semesterMapper.selectByExample(semesterExample);
    }

    @Override
    public List<ImsSemester> list() {
        return semesterMapper.selectByExample(new ImsSemesterExample());
    }

    @Override
    public ImsSemester get(Long id) {
        return semesterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(ImsSemester semester) {
        return semesterMapper.insertSelective(semester);
    }

    @Override
    public int delete(Long id) {
        return semesterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, ImsSemester semester) {
        semester.setId(id);
        return semesterMapper.updateByPrimaryKeySelective(semester);
    }

    @Override
    public int updateByParam(Long id, ImsSemesterParam semesterParam){
        ImsSemester semester = new ImsSemester();
        //将semesterParam中与semester相同字段进行拷贝
        BeanUtils.copyProperties(semesterParam, semester);
        //根据其他字段信息生成学期描述
        semester.setDescription(ImsConstant.parseSemesterDescription(semester));
        semester.setId(id);
        return semesterMapper.updateByPrimaryKeySelective(semester);
    }

    @Override
    public int insertByParam(ImsSemesterParam semesterParam) {
        ImsSemester semester = new ImsSemester();
        //将semesterParam中与semester相同字段进行拷贝
        BeanUtils.copyProperties(semesterParam, semester);
        //根据其他字段信息生成学期描述
        semester.setDescription(ImsConstant.parseSemesterDescription(semester));
        return semesterMapper.insertSelective(semester);
    }
}
