package com.crayon.youcanpass.dao;

import com.crayon.youcanpass.dto.CmsFavoriteOpenCourseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CmsFavoriteOpenCourseDao
 * @Description 选课收藏Dao层
 * @Date 2020/2/27 15:59
 * @Created by Crayon
 */
public interface CmsFavoriteOpenCourseDao {
    List<CmsFavoriteOpenCourseDto> list(@Param("userId") Long userId, @Param("semesterId") Long semesterId);
}
