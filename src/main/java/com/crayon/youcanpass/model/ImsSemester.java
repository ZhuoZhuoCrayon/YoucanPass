package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ImsSemester implements Serializable {
    @ApiModelProperty(value = "学期信息id:primary key")
    private Long id;

    @ApiModelProperty(value = "起始年度:2019")
    private Integer beginYear;

    @ApiModelProperty(value = "截至年度:2020")
    private Integer endYear;

    @ApiModelProperty(value = "学期:1->第一学期/2->第二学期")
    private Integer term;

    @ApiModelProperty(value = "学期信息描述:2019-2020学年度第二学期")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(Integer beginYear) {
        this.beginYear = beginYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", beginYear=").append(beginYear);
        sb.append(", endYear=").append(endYear);
        sb.append(", term=").append(term);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}