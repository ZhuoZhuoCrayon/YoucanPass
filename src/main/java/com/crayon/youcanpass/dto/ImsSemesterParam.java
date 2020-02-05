package com.crayon.youcanpass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Classname ImsSemesterParam
 * @Description 学期信息构造传递模型
 * @Date 2020/2/5 15:04
 * @Created by Crayon
 */
@Setter
@Getter
@ToString
public class ImsSemesterParam {
    @ApiModelProperty(value = "起始年度:2019")
    @NotNull(message = "起始年度不能为空")
    @Range(min = 1983, max = 2100, message = "年份信息须在合法范围内(1983-2100)")
    private Integer beginYear;

    @ApiModelProperty(value = "截至年度:2020")
    @NotNull(message = "截至年度不能为空")
    @Range(min = 1983, max = 2100, message = "年份信息须在合法范围内(1983-2100)")
    private Integer endYear;

    @ApiModelProperty(value = "学期:1->第一学期/2->第二学期")
    @NotNull(message = "学期信息不能为空")
    @Range(min = 1, max = 2, message = "1->第一学期/2->第二学期")
    private Integer term;
}
