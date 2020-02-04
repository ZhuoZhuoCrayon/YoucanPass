package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@ToString
public class UmsUserLoginParam {

    @ApiModelProperty(value = "学号/教工号", required = true)
    @NotEmpty(message = "学号/教工号不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
}
