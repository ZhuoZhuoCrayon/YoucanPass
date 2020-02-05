package com.crayon.youcanpass.service;

import com.crayon.youcanpass.model.CmsCourse;

import java.util.List;

/**
 * @Classname CmsCourseService
 * @Description TODO
 * @Date 2020/2/5 20:16
 * @Created by Crayon
 */
public interface CmsCourseService extends BaseService<CmsCourse> {
    /**
     * 分页查询
     */
    List<CmsCourse> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 批量修改审核状态
     */
    int updateStatusBatch(List<Long> ids, Integer status);

    /**
     * 批量修改开课学期
     */
    int updateTermBatch(List<Long> ids, Integer term);

    /**
     * 批量修改课程类型
     */
    int updateTypeBatch(List<Long> ids, Integer type);
}
