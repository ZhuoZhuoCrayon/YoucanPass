package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.dto.UmsUserDetailDto;
import com.crayon.youcanpass.dto.UmsUserLoginParam;
import com.crayon.youcanpass.model.UmsPermission;
import com.crayon.youcanpass.model.UmsUser;
import com.crayon.youcanpass.service.UmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理控制层
 * Created by crayon on 2020/02/05
 */
@Api(tags = "UmsUserController", description = "用户管理")
@RestController
@RequestMapping("/ums/user")
public class UmsUserController {
    @Autowired
    private UmsUserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation("获取指定id用户的权限信息:前期接口测试")
    @RequestMapping(value = "/{id}/permissions", method = RequestMethod.GET)
    public CommonResult<List<UmsPermission>> list(@PathVariable("id") Long id){
        return CommonResult.success(userService.listPermissionByUserId(id, 2, 1));
    }

    @ApiOperation("获取用户登录信息")
    @RequestMapping(value = "/login-info", method = RequestMethod.GET)
    public CommonResult<UmsUserDetailDto> getUserLoginInfo(){
        return CommonResult.success(userService.getUserLoginInfo());
    }

    @ApiOperation("用户登录:成功返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody @Valid UmsUserLoginParam userLoginParam){
        String token = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if(token == null){
            return CommonResult.failed("用户名密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("更新指定id用户信息:前期测试接口")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable("id") Long id,
                               @RequestBody UmsUser user){
        CommonResult commonResult;
        int count = userService.update(id, user);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }

}
