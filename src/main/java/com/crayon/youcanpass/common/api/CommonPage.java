package com.crayon.youcanpass.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页数据封装类
 * Create by crayon on 2020/02/02
 *
 * Introduce:
 * MyBatis分页插件，简单的几行代码就能实现分页
 * 在与SpringBoot整合时，只要整合了PagerHelper就自动整合了MyBatis。
 *
 * Apply:
 *  service层:
 *      1:调用PageHelper
 *      PageHelper.startPage(pageNum, pageSize);
 *      2:进行查询操作将自动进行分页
 *      List<Item> itemList = itemMapper.selectByExample(new ItemExample());
 *  分页封装类:
 *      1:通过构造PageInfo对象获取分页信息，如当前页码，总页数，总条数
 *      PageInfo<Item> pageInfo = new PageInfo<item>(itemList);
 */

public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
