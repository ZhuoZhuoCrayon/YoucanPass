package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmsOpencourseRecord implements Serializable {
    @ApiModelProperty(value = "课程记录id:primary key")
    private Long id;

    @ApiModelProperty(value = "选课关系id:关联cms_user_opencourse_relation(选课关系表)")
    private Long userOpencourceId;

    @ApiModelProperty(value = "上课日期")
    private Date courseDate;

    @ApiModelProperty(value = "上课时间:单位：Hour")
    private Float courseTime;

    @ApiModelProperty(value = "提交日期")
    private Date commitDate;

    @ApiModelProperty(value = "状态:0->学生未确认/1->学生确认")
    private Integer status;

    @ApiModelProperty(value = "备注信息")
    private String note;

    @ApiModelProperty(value = "状态信息")
    private String statusComment;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserOpencourceId() {
        return userOpencourceId;
    }

    public void setUserOpencourceId(Long userOpencourceId) {
        this.userOpencourceId = userOpencourceId;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public Float getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Float courseTime) {
        this.courseTime = courseTime;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
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
        sb.append(", userOpencourceId=").append(userOpencourceId);
        sb.append(", courseDate=").append(courseDate);
        sb.append(", courseTime=").append(courseTime);
        sb.append(", commitDate=").append(commitDate);
        sb.append(", status=").append(status);
        sb.append(", note=").append(note);
        sb.append(", statusComment=").append(statusComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}