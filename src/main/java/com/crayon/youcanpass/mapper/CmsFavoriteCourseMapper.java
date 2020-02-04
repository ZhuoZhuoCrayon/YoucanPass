package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.CmsFavoriteCourse;
import com.crayon.youcanpass.model.CmsFavoriteCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsFavoriteCourseMapper {
    int countByExample(CmsFavoriteCourseExample example);

    int deleteByExample(CmsFavoriteCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsFavoriteCourse record);

    int insertSelective(CmsFavoriteCourse record);

    List<CmsFavoriteCourse> selectByExampleWithBLOBs(CmsFavoriteCourseExample example);

    List<CmsFavoriteCourse> selectByExample(CmsFavoriteCourseExample example);

    CmsFavoriteCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsFavoriteCourse record, @Param("example") CmsFavoriteCourseExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsFavoriteCourse record, @Param("example") CmsFavoriteCourseExample example);

    int updateByExample(@Param("record") CmsFavoriteCourse record, @Param("example") CmsFavoriteCourseExample example);

    int updateByPrimaryKeySelective(CmsFavoriteCourse record);

    int updateByPrimaryKeyWithBLOBs(CmsFavoriteCourse record);

    int updateByPrimaryKey(CmsFavoriteCourse record);
}