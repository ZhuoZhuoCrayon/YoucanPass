package com.crayon.youcanpass.service;

import com.crayon.youcanpass.dto.CmsOpenCourseForUserParam;
import com.crayon.youcanpass.dto.CmsOpenCourseQuery;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import com.crayon.youcanpass.model.CmsOpencourse;

import java.util.List;

/**
 * @Classname CmsOpenCourseService
 * @Description 开课信息管理Service层
 * @Date 2020/2/7 11:24
 * @Created by Crayon
 */
public interface CmsOpenCourseService {

    /**
     * 检查输入参数
     */
    void checkParam(CmsOpenCourseForUserParam openCourseForUserParam);

    /**
     * 根据id获取开课信息
     */
    CmsOpencourse get(Long id);

    /**
     * 分页按条件查询概要开课信息
     */
    List<CmsOpenCourseSimpleDto> listOpenCourseSimpleByQuery(CmsOpenCourseQuery openCourseQuery, Integer pageNum, Integer pageSize);

    /**
     * 登录用户创建课程
     */
    int insertByLoginUser(CmsOpenCourseForUserParam openCourseForUserParam);

    /**
     * 删除指定id的开课信息
     */
    int delete(Long id);

    /**
     * 批量删除开课信息
     */
    int deleteBatch(List<Long> ids);

    /**
     * 更新开课信息
     */
    int update(Long id, CmsOpenCourseForUserParam openCourseForUserParam);

    /**
     * 批量更新开课状态
     */
    int updateStatusBatch(List<Long> ids, Integer status, String statusComment);


}
