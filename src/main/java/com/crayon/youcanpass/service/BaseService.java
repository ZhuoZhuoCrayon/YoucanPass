package com.crayon.youcanpass.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service 封装接口
 * Created by crayon on 2020/02/02
 */
public interface BaseService<T> {
    /**
     * 根据id获取
     */
    T get(Long id);

    /**
     * 获取全部信息
     */
    List<T> list();

    /**
     * 插入
     */
    @Transactional
    int insert(T t);

    /**
     * 根据id删除
     */
    @Transactional
    int delete(Long id);

    /**
     * 根据id更新
     */
    @Transactional
    int update(Long id, T t);
}
