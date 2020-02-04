package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsUserFreetimeRelation implements Serializable {
    @ApiModelProperty(value = "空闲表id:primary key")
    private Long id;

    @ApiModelProperty(value = "用户id:关联ums_user")
    private Long userId;

    @ApiModelProperty(value = "空闲时间id:关联sms_freetime")
    private Long freetimeId;

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

    public Long getFreetimeId() {
        return freetimeId;
    }

    public void setFreetimeId(Long freetimeId) {
        this.freetimeId = freetimeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", freetimeId=").append(freetimeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}