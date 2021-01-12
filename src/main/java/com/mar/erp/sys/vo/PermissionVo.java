package com.mar.erp.sys.vo;

import com.mar.erp.sys.model.Permission;

import java.util.ArrayList;
import java.util.List;


public class PermissionVo extends Permission {

    private List<Permission> permissionList=new ArrayList<>();

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
