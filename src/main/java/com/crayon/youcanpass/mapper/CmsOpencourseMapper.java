package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.CmsOpencourse;
import com.crayon.youcanpass.model.CmsOpencourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsOpencourseMapper {
    int countByExample(CmsOpencourseExample example);

    int deleteByExample(CmsOpencourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsOpencourse record);

    int insertSelective(CmsOpencourse record);

    List<CmsOpencourse> selectByExampleWithBLOBs(CmsOpencourseExample example);

    List<CmsOpencourse> selectByExample(CmsOpencourseExample example);

    CmsOpencourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsOpencourse record, @Param("example") CmsOpencourseExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsOpencourse record, @Param("example") CmsOpencourseExample example);

    int updateByExample(@Param("record") CmsOpencourse record, @Param("example") CmsOpencourseExample example);

    int updateByPrimaryKeySelective(CmsOpencourse record);

    int updateByPrimaryKeyWithBLOBs(CmsOpencourse record);

    int updateByPrimaryKey(CmsOpencourse record);
}