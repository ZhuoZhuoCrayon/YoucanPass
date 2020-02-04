package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsFreetime implements Serializable {
    @ApiModelProperty(value = "空闲时间id")
    private Long id;

    @ApiModelProperty(value = "空闲天:1-7->周一到周日")
    private Integer weekday;

    @ApiModelProperty(value = "空闲开始时间段:1、2......12")
    private Integer sectionBegin;

    @ApiModelProperty(value = "空闲结束时间段:1、2......12")
    private Integer sectionEnd;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getSectionBegin() {
        return sectionBegin;
    }

    public void setSectionBegin(Integer sectionBegin) {
        this.sectionBegin = sectionBegin;
    }

    public Integer getSectionEnd() {
        return sectionEnd;
    }

    public void setSectionEnd(Integer sectionEnd) {
        this.sectionEnd = sectionEnd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", weekday=").append(weekday);
        sb.append(", sectionBegin=").append(sectionBegin);
        sb.append(", sectionEnd=").append(sectionEnd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}