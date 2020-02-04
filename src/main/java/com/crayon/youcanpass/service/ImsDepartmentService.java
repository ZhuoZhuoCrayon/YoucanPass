package com.crayon.youcanpass.service;

import com.crayon.youcanpass.model.ImsDepartment;

import java.util.List;

/**
 * 部门信息管理Service
 * Created by crayon on 2020/02/02
 */

public interface ImsDepartmentService extends BaseService<ImsDepartment>{

    /**
     * 分页查询
     */
    List<ImsDepartment> listByPage(Integer pageNum, Integer pageSize);
}
