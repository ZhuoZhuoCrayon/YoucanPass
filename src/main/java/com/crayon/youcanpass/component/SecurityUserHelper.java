package com.crayon.youcanpass.component;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Classname SecurityUserHelper
 * @Description 获取当前登录用户名
 * @Date 2020/2/6 11:28
 * @Created by Crayon
 */
public class SecurityUserHelper {
    public static String getLoginUserName (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return null;
    }
}
