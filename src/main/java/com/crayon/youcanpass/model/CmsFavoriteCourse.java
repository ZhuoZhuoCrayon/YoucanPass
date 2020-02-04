package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CmsFavoriteCourse implements Serializable {
    @ApiModelProperty(value = "收藏id")
    private Long id;

    @ApiModelProperty(value = "用户id:关联ums_user")
    private Long userId;

    @ApiModelProperty(value = "开课信息id:关联cms_opencourse")
    private Long opencourseId;

    @ApiModelProperty(value = "学期信息id:关联ims_semester")
    private Long semesterId;

    @ApiModelProperty(value = "备注信息")
    private String note;

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

    public Long getOpencourseId() {
        return opencourseId;
    }

    public void setOpencourseId(Long opencourseId) {
        this.opencourseId = opencourseId;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", opencourseId=").append(opencourseId);
        sb.append(", semesterId=").append(semesterId);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}