package com.mar.erp.sys.vo;

import com.mar.erp.sys.model.Permission;

import java.util.ArrayList;
import java.util.List;


public class PermissionVo extends Permission {

    private List<PermissionVo> permissionList=new ArrayList<>();

    public List<PermissionVo> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionVo> permissionList) {
        this.permissionList = permissionList;
    }
}
