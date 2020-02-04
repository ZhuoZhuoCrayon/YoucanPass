package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.CmsCourse;
import com.crayon.youcanpass.model.CmsCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseMapper {
    int countByExample(CmsCourseExample example);

    int deleteByExample(CmsCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourse record);

    int insertSelective(CmsCourse record);

    List<CmsCourse> selectByExample(CmsCourseExample example);

    CmsCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourse record, @Param("example") CmsCourseExample example);

    int updateByExample(@Param("record") CmsCourse record, @Param("example") CmsCourseExample example);

    int updateByPrimaryKeySelective(CmsCourse record);

    int updateByPrimaryKey(CmsCourse record);
}