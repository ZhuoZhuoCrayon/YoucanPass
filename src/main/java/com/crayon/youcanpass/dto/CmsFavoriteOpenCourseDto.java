package com.crayon.youcanpass.dto;

import com.crayon.youcanpass.model.CmsFavoriteOpencourse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Classname CmsFavoriteOpenCourseDto
 * @Description 选课收藏传输层
 * @Date 2020/2/27 15:54
 * @Created by Crayon
 */
@Setter
@Getter
@ToString
public class CmsFavoriteOpenCourseDto extends CmsFavoriteOpencourse {
    @ApiModelProperty(value = "课程名")
    private String courseName;
    @ApiModelProperty(value = "开课用户姓名")
    private String realName;
    @ApiModelProperty(value = "选课人数限制")
    private Integer selectLimit;
    @ApiModelProperty(value = "选课人数")
    private Integer selectCount;
    @ApiModelProperty(value = "审核状态:-1->未通过审核/0->待审核/1->审核通过（可选）/2->不可选/3->过期不可选")
    private Integer status;
}
