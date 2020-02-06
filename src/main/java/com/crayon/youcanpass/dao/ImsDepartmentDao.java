package com.crayon.youcanpass.dao;

import com.crayon.youcanpass.dto.ImsDepartmentTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname ImsDepartmentDao
 * @Description 部门信息Dao层
 * @Date 2020/2/6 17:14
 * @Created by Crayon
 */
public interface ImsDepartmentDao {
    /**
     * 根据部门id回溯获取部门所属层次信息
     */
    ImsDepartmentTreeNode getDepartmentRoot(@Param("id") Long id);

    /**
     * 列举 id以下的部门层次结构
     */
    List<ImsDepartmentTreeNode> listDepartmentStructure(@Param("id") Long id);
}
