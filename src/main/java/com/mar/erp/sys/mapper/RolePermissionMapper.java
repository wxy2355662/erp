package com.mar.erp.sys.mapper;

import com.mar.erp.sys.model.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rpId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rpId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}