package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CmsCourse implements Serializable {
    @ApiModelProperty(value = "课程id")
    private Long id;

    @ApiModelProperty(value = "开课单位id，精确到学院/学部")
    @NotNull(message = "开课单位id不得为空")
    @Min(value = 1, message = "开课id为正整数")
    private Long departmentId;

    @ApiModelProperty(value = "课程名称")
    @NotNull(message = "课程名称不得为空")
    private String name;

    @ApiModelProperty(value = "课程类型:0->专业核心课/1->专业选修课/2-其他")
    @NotNull(message = "课程类型不得为空")
    @Range(min = 0, max = 3, message = "课程类型:0->专业核心课/1->专业选修课/2-其他")
    private Integer type;

    @ApiModelProperty(value = "开课学期:1->第一学期/2->第二学期/3->全年开设")
    @NotNull(message = "开课学期不得为空")
    @Range(min = 1, max = 3, message = "开课学期:1->第一学期/2->第二学期/3->全年开设")
    private Integer term;

    @ApiModelProperty(value = "启用状态:0->禁用/1->启用")
    @NotNull(message = "启用状态不得为空")
    @Range(min = 0, max = 1, message = "启用状态:0->禁用/1->启用")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", term=").append(term);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}