package com.crayon.youcanpass.service;
import com.crayon.youcanpass.dto.UmsUserDetailDto;
import com.crayon.youcanpass.model.UmsPermission;
import com.crayon.youcanpass.model.UmsUser;

import java.util.List;

public interface UmsUserService {

    /**
     * 根据用户名获取用户
     */
    UmsUser getUserByUserName(String username);

    /**
     * 获取用户登录信息
     */
    UmsUserDetailDto getUserLoginInfo();

    /**
     * 登录功能
     * @param username 学号/教工号
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 按id更新
     */
    Integer update(Long id, UmsUser umsUser);

    /**
     * 根据条件筛选指定userId的权限信息
     * @param userId
     * @param permissionType 权限类型:0->管理层/1->管理表/2->绑定权限
     * @param permissionStatus 启用状态:0->禁用/1->启用
     * @return 权限信息列表
     */
    List<UmsPermission> listPermissionByUserId(Long userId, Integer permissionType, Integer permissionStatus);



}
