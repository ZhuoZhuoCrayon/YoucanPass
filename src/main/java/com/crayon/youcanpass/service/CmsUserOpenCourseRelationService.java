package com.crayon.youcanpass.service;

import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationDto;
import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationQuery;
import com.crayon.youcanpass.model.CmsUserOpencourseRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname CmsUserOpenCourseRelationService
 * @Description 选课管理Service层
 * @Date 2020/2/12 21:24
 * @Created by Crayon
 */
public interface CmsUserOpenCourseRelationService {

    /**
     * 根据id获取选课关系
     */
    CmsUserOpencourseRelation get(Long id);

    /**
     * 根据查询条件分页查询选课信息
     */
    List<CmsUserOpenCourseRelationDto> listByPageQuery(CmsUserOpenCourseRelationQuery userOpenCourseRelationQuery,
                                                       Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件查询全部
     */
    List<CmsUserOpenCourseRelationDto> listByQuery(CmsUserOpenCourseRelationQuery userOpenCourseRelationQuery);

    /**
     * 用户选课
     */
    @Transactional
    int select(Long opencourseId);

    /**
     * 用户退选
     */
    @Transactional
    int delete(Long id);

    /**
     * 批量退选：管理员
     */
    @Transactional
    int deleteBatch(List<Long> ids);

    /**
     * 批量修改状态：管理员
     */
    @Transactional
    int updateStatusBatch(List<Long> ids, Integer status, String statusComment);

    /**
     * 修改选课状态
     */
    @Transactional
    int updateStatus(Long id, Integer status, String statusComment);
}
