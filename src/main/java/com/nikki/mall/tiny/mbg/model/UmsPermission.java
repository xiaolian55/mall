package com.nikki.mall.tiny.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class UmsPermission implements Serializable {

    private Long id;
    private Long pid;
    private String name;
    private String value;
    private String icon;
    private String type;
    private String uri;
    private String status;
    private Date createTime;
    private Integer sort;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append("Hash = ").append(hashCode());
        sb.append("id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name='").append(name).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", uri='").append(uri).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", sort=").append(sort);
        sb.append('}');
        return sb.toString();
    }
}
