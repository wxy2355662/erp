package com.mar.erp.sys.model;

public class AtaffRole {
    private Integer arId;

    private Integer aId;

    private Integer roleId;

    public AtaffRole(Integer arId, Integer aId, Integer roleId) {
        this.arId = arId;
        this.aId = aId;
        this.roleId = roleId;
    }

    public AtaffRole() {
        super();
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}