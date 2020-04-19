package com.nikki.mall.tiny.mbg.model;


import java.io.Serializable;

public class UmsAdminPermissionRelation implements Serializable {
    private Long id;
    private  Long adminId;
    private Long permissionId;
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append("Hash = ").append(hashCode());
        sb.append("id=").append(id);
        sb.append(", adminId=").append(adminId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
