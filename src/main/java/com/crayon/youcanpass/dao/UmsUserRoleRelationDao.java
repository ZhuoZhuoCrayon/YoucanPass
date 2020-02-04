package com.crayon.youcanpass.dao;

import com.crayon.youcanpass.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsUserRoleRelationDao {

    /**
     * 根据条件筛选指定userId的权限信息
     * @param userId 用户id
     * @param type 权限类型:0->管理层/1->管理表/2->绑定权限
     * @param status 启用状态:0->禁用/1->启用
     * @return 权限信息列表
     */
    List<UmsPermission> listPermissionsByUserId(@Param("userId") Long userId,
                                                @Param("type") Integer type,
                                                @Param("status") Integer status);
}
