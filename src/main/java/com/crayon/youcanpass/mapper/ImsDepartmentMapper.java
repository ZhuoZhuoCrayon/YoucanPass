package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.ImsDepartment;
import com.crayon.youcanpass.model.ImsDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsDepartmentMapper {
    int countByExample(ImsDepartmentExample example);

    int deleteByExample(ImsDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsDepartment record);

    int insertSelective(ImsDepartment record);

    List<ImsDepartment> selectByExample(ImsDepartmentExample example);

    ImsDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsDepartment record, @Param("example") ImsDepartmentExample example);

    int updateByExample(@Param("record") ImsDepartment record, @Param("example") ImsDepartmentExample example);

    int updateByPrimaryKeySelective(ImsDepartment record);

    int updateByPrimaryKey(ImsDepartment record);
}