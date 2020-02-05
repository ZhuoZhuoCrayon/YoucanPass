package com.crayon.youcanpass.service;

import com.crayon.youcanpass.dto.ImsSemesterParam;
import com.crayon.youcanpass.model.ImsSemester;

import java.util.List;

/**
 * @Classname ImsSemesterService
 * @Description 学期信息管理Service接口层
 * @Date 2020/2/5 15:13
 * @Created by Crayon
 */
public interface ImsSemesterService extends BaseService<ImsSemester> {

    /**
     * 按年度范围获取学期信息
     */
    List<ImsSemester> listByTimeRange(Integer begin, Integer end);

    /**
     * 根据构造参数更新学期信息
     */
    int updateByParam(Long id, ImsSemesterParam semesterParam);

    /**
     * 根据构造参数新增学期信息
     */
    int insertByParam(ImsSemesterParam semesterParam);
}
