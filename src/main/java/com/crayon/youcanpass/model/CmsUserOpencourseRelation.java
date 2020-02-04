package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CmsUserOpencourseRelation implements Serializable {
    @ApiModelProperty(value = "选课关系id")
    private Long id;

    @ApiModelProperty(value = "选课用户id:关联ums_user")
    private Long userId;

    @ApiModelProperty(value = "开课信息id:关联cms_opencourse")
    private Long opencourseId;

    @ApiModelProperty(value = "评价等级:0-5")
    private Integer evaluationLevel;

    @ApiModelProperty(value = "附件信息:附件信息")
    private String fileUrl;

    @ApiModelProperty(value = "选课状态:0->待审核/1->审核通过/2->讲师确认/3->学生确认/4->上课中/5->结课(待评价)/-1->审核不通过/-2->退选")
    private Integer status;

    @ApiModelProperty(value = "评价文本")
    private String evaluationText;

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

    public Long getOpencourseId() {
        return opencourseId;
    }

    public void setOpencourseId(Long opencourseId) {
        this.opencourseId = opencourseId;
    }

    public Integer getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(Integer evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEvaluationText() {
        return evaluationText;
    }

    public void setEvaluationText(String evaluationText) {
        this.evaluationText = evaluationText;
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
        sb.append(", opencourseId=").append(opencourseId);
        sb.append(", evaluationLevel=").append(evaluationLevel);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", status=").append(status);
        sb.append(", evaluationText=").append(evaluationText);
        sb.append(", statusComment=").append(statusComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}