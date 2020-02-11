package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Classname CmsOpenCourseForUserParam
 * @Description 用户开课构造传递模型
 * @Date 2020/2/7 14:16
 * @Created by Crayon
 */
@Getter
@Setter
@ToString
public class CmsOpenCourseForUserParam {

    @ApiModelProperty(value = "课程id:关联 cms_course")
    @NotNull(message = "开课课程不能为空")
    private Long courseId;

    @ApiModelProperty(value = "学期信息id:关联ims_semester")
    @NotNull(message = "开课学期不能为空")
    private Long semesterId;

    @ApiModelProperty(value = "课程人数限制")
    @NotNull(message = "选课人数限制不能为空")
    @Range(min = 1, max = 99, message = "选课人数限制需在（1-99）范围内")
    private Integer selectLimit;

    @ApiModelProperty(value = "课程备注信息")
    private String note;
}
