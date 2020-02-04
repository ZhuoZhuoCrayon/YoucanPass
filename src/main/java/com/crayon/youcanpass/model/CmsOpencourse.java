package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CmsOpencourse implements Serializable {
    @ApiModelProperty(value = "开课信息id")
    private Long id;

    @ApiModelProperty(value = "开课用户id:关联ums_user")
    private Long userId;

    @ApiModelProperty(value = "课程id:关联 cms_course")
    private Long courseId;

    @ApiModelProperty(value = "学期信息id:关联cims_semester")
    private Long semesterId;

    @ApiModelProperty(value = "课程人数限制")
    private Integer selectLimit;

    @ApiModelProperty(value = "选课人数")
    private Integer selectCount;

    @ApiModelProperty(value = "审核状态:-1->未通过审核/0->待审核/1->审核通过（可选）/2->不可选/3->过期不可选")
    private Integer status;

    @ApiModelProperty(value = "课程备注信息")
    private String note;

    @ApiModelProperty(value = "审核评价")
    private String statusComment;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSelectLimit() {
        return selectLimit;
    }

    public void setSelectLimit(Integer selectLimit) {
        this.selectLimit = selectLimit;
    }

    public Integer getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(Integer selectCount) {
        this.selectCount = selectCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", courseId=").append(courseId);
        sb.append(", semesterId=").append(semesterId);
        sb.append(", selectLimit=").append(selectLimit);
        sb.append(", selectCount=").append(selectCount);
        sb.append(", status=").append(status);
        sb.append(", note=").append(note);
        sb.append(", statusComment=").append(statusComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}