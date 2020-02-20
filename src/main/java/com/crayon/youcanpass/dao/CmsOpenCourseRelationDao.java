package com.crayon.youcanpass.dao;

import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationDto;
import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CmsOpenCourseRelationDao
 * @Description 选课信息额外功能实现接口
 * @Date 2020/2/12 22:40
 * @Created by Crayon
 */
public interface CmsOpenCourseRelationDao {
    /**
     * 根据查询类查询选课信息
     */
    List<CmsUserOpenCourseRelationDto> listCmsUserOpenCourseRelationDtoByQuery(
            @Param("query") CmsUserOpenCourseRelationQuery query);
}
