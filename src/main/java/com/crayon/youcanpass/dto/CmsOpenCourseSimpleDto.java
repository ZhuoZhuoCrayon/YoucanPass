package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Classname CmsOpenCourseSimpleDto
 * @Description 开课信息概要
 * @Date 2020/2/10 23:17
 * @Created by Crayon
 */
@Getter
@Setter
@ToString
public class CmsOpenCourseSimpleDto {
    @ApiModelProperty(value = "开课id")
    private Long id;
    @ApiModelProperty(value = "开课用户姓名")
    private String realName;
    @ApiModelProperty(value = "开课用户学号")
    private String username;
    @ApiModelProperty(value = "课程名")
    private String courseName;
    @ApiModelProperty(value = "课程类型:0->专业核心课/1->专业选修课/2-其他")
    private Integer courseType;
    @ApiModelProperty(value = "开课学期")
    private String semesterDescription;
    @ApiModelProperty(value = "选课人数限制")
    private Integer selectLimit;
    @ApiModelProperty(value = "选课人数")
    private Integer selectCount;
    @ApiModelProperty(value = "审核状态:-1->未通过审核/0->待审核/1->审核通过（可选）/2->不可选/3->过期不可选")
    private Integer status;
}
