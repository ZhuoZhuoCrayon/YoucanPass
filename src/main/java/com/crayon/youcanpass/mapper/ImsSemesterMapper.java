package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.ImsSemester;
import com.crayon.youcanpass.model.ImsSemesterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsSemesterMapper {
    int countByExample(ImsSemesterExample example);

    int deleteByExample(ImsSemesterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsSemester record);

    int insertSelective(ImsSemester record);

    List<ImsSemester> selectByExample(ImsSemesterExample example);

    ImsSemester selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsSemester record, @Param("example") ImsSemesterExample example);

    int updateByExample(@Param("record") ImsSemester record, @Param("example") ImsSemesterExample example);

    int updateByPrimaryKeySelective(ImsSemester record);

    int updateByPrimaryKey(ImsSemester record);
}