package com.mar.erp.sys.model;

public class RolePermission {
    private Integer rpId;

    private Integer roleId;

    private Integer perId;

    public RolePermission(Integer rpId, Integer roleId, Integer perId) {
        this.rpId = rpId;
        this.roleId = roleId;
        this.perId = perId;
    }

    public RolePermission() {
        super();
    }

    public Integer getRpId() {
        return rpId;
    }

    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }
}