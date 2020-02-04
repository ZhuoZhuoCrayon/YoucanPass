package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.CmsUserOpencourseRelation;
import com.crayon.youcanpass.model.CmsUserOpencourseRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsUserOpencourseRelationMapper {
    int countByExample(CmsUserOpencourseRelationExample example);

    int deleteByExample(CmsUserOpencourseRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsUserOpencourseRelation record);

    int insertSelective(CmsUserOpencourseRelation record);

    List<CmsUserOpencourseRelation> selectByExampleWithBLOBs(CmsUserOpencourseRelationExample example);

    List<CmsUserOpencourseRelation> selectByExample(CmsUserOpencourseRelationExample example);

    CmsUserOpencourseRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsUserOpencourseRelation record, @Param("example") CmsUserOpencourseRelationExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsUserOpencourseRelation record, @Param("example") CmsUserOpencourseRelationExample example);

    int updateByExample(@Param("record") CmsUserOpencourseRelation record, @Param("example") CmsUserOpencourseRelationExample example);

    int updateByPrimaryKeySelective(CmsUserOpencourseRelation record);

    int updateByPrimaryKeyWithBLOBs(CmsUserOpencourseRelation record);

    int updateByPrimaryKey(CmsUserOpencourseRelation record);
}