package com.crayon.youcanpass.dao;

import com.crayon.youcanpass.dto.CmsOpenCourseQuery;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CmsOpenCourseDao
 * @Description 开课管理额外实现接口
 * @Date 2020/2/10 23:34
 * @Created by Crayon
 */
public interface CmsOpenCourseDao {
    List<CmsOpenCourseSimpleDto> listOpenCoursesByQuery(@Param("query") CmsOpenCourseQuery query);
}
