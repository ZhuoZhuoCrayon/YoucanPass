package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Classname CmsUserOpenCourseRelationQuery
 * @Description 选课查询参数
 * @Date 2020/2/12 22:30
 * @Created by Crayon
 */
@Setter
@Getter
@ToString
public class CmsUserOpenCourseRelationQuery {
    @ApiModelProperty(value = "选课关系id")
    private Long id;

    @ApiModelProperty(value = "开课信息id:关联cms_opencourse")
    private Long opencourseId;

    @ApiModelProperty(value = "学号/教工号")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "学期信息描述:2019-2020学年度第二学期")
    private String semesterDescription;

    @ApiModelProperty(value = "选课状态:0->待审核/1->审核通过/2->讲师确认/3->学生确认/4->上课中/5->结课(待评价)/-1->审核不通过")
    private Integer status;
}
