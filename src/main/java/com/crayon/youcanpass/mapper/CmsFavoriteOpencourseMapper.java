package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.CmsFavoriteOpencourse;
import com.crayon.youcanpass.model.CmsFavoriteOpencourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsFavoriteOpencourseMapper {
    int countByExample(CmsFavoriteOpencourseExample example);

    int deleteByExample(CmsFavoriteOpencourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsFavoriteOpencourse record);

    int insertSelective(CmsFavoriteOpencourse record);

    List<CmsFavoriteOpencourse> selectByExampleWithBLOBs(CmsFavoriteOpencourseExample example);

    List<CmsFavoriteOpencourse> selectByExample(CmsFavoriteOpencourseExample example);

    CmsFavoriteOpencourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsFavoriteOpencourse record, @Param("example") CmsFavoriteOpencourseExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsFavoriteOpencourse record, @Param("example") CmsFavoriteOpencourseExample example);

    int updateByExample(@Param("record") CmsFavoriteOpencourse record, @Param("example") CmsFavoriteOpencourseExample example);

    int updateByPrimaryKeySelective(CmsFavoriteOpencourse record);

    int updateByPrimaryKeyWithBLOBs(CmsFavoriteOpencourse record);

    int updateByPrimaryKey(CmsFavoriteOpencourse record);
}