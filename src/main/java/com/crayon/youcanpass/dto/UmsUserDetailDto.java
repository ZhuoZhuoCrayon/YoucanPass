package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Classname UmsUserDetailDto
 * @Description 用户概要信息（登录信息）
 * @Date 2020/2/6 19:19
 * @Created by Crayon
 */
@Setter
@Getter
public class UmsUserDetailDto {

    @ApiModelProperty(value = "学号/教工号")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "角色信息")
    private List<String> roleNames;

    @ApiModelProperty(value = "部门归属链")
    private ImsDepartmentTreeNode departmentChains;
}
