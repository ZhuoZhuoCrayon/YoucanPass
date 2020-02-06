package com.crayon.youcanpass.service;

import com.crayon.youcanpass.dto.ImsDepartmentTreeNode;
import com.crayon.youcanpass.model.ImsDepartment;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据部门id回溯获取部门所属层次信息
     */
    ImsDepartmentTreeNode getDepartmentRoot(Long id);

    /**
     * 列举 id以下的部门层次结构
     */
    List<ImsDepartmentTreeNode> listDepartmentStructure(Long id);
}
