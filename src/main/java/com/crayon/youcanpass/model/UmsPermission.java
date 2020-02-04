package com.crayon.youcanpass.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsPermission implements Serializable {
    @ApiModelProperty(value = "权限id:自增")
    private Long id;

    @ApiModelProperty(value = "父级权限")
    private Long pid;

    @ApiModelProperty(value = "权限类型:0->管理层/1->管理表/2->绑定权限")
    private Integer type;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限值:ums:user:insert")
    private String value;

    @ApiModelProperty(value = "权限路径:/ums/user/insert")
    private String url;

    @ApiModelProperty(value = "启用状态:0->禁用/1->启用")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        sb.append(", pid=").append(pid);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", url=").append(url);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}