package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.mapper.ImsDepartmentMapper;
import com.crayon.youcanpass.model.ImsDepartment;
import com.crayon.youcanpass.model.ImsDepartmentExample;
import com.crayon.youcanpass.service.ImsDepartmentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ImsDepartmentService实现类
 * Created by crayon on 2020/02/02
 */


@Service
public class ImsDepartmentServiceImpl implements ImsDepartmentService {
    @Autowired
    private ImsDepartmentMapper departmentMapper;

    @Override
    public List<ImsDepartment> listByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return departmentMapper.selectByExample(new ImsDepartmentExample());
    }

    @Override
    public ImsDepartment get(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ImsDepartment> list() {
        return departmentMapper.selectByExample(new ImsDepartmentExample());
    }

    @Override
    public int insert(ImsDepartment department) {
        department.setId(null);
        return departmentMapper.insertSelective(department);
    }

    @Override
    public int delete(Long id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, ImsDepartment department) {
        department.setId(id);
        return departmentMapper.updateByPrimaryKeySelective(department);
    }
}
