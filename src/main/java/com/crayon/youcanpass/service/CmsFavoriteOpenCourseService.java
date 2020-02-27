package com.crayon.youcanpass.service;

import com.crayon.youcanpass.dto.CmsFavoriteOpenCourseDto;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import com.crayon.youcanpass.model.CmsFavoriteOpencourse;

import java.util.List;

/**
 * @Classname CmsFavoriteOpenCourseService
 * @Description 收藏课程业务层接口
 * @Date 2020/2/27 15:34
 * @Created by Crayon
 */
public interface CmsFavoriteOpenCourseService extends BaseService<CmsFavoriteOpencourse> {
    /**
     * 根据用户id列举
     */
    List<CmsFavoriteOpenCourseDto> list(Long userId, Long semesterId);

    int delete(Long userId ,Long id);



}
