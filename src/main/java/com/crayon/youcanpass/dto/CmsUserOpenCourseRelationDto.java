package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Classname CmsUserOpenCourseRelationDto
 * @Description 选课信息传输类
 * @Date 2020/2/12 22:34
 * @Created by Crayon
 */
@Getter
@Setter
@ToString
public class CmsUserOpenCourseRelationDto extends CmsUserOpenCourseRelationQuery {
    @ApiModelProperty(value = "审核评价")
    private String statusComment;
}
