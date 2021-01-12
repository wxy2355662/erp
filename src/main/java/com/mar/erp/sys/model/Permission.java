package com.mar.erp.sys.model;

public class Permission {
    private Integer perId;

    private String perName;

    private Integer pid;

    private String permission;

    private String icon;//图标

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Permission(Integer perId, String perName, Integer pid, String permission, String icon) {
        this.perId = perId;
        this.perName = perName;
        this.pid = pid;
        this.permission = permission;
        this.icon=icon;
    }

    public Permission() {
        super();
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}