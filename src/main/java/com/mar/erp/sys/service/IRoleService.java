package com.mar.erp.sys.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.sys.model.Role;

import java.util.List;

public interface IRoleService {
    JsonResponseBody<?> deleteByPrimaryKey(Integer roleId);

    JsonResponseBody<?> insert(Role record);

    JsonResponseBody<?> insertSelective(Role record);

    JsonResponseBody<Role> selectByPrimaryKey(Integer roleId);

    JsonResponseBody<?> updateByPrimaryKeySelective(Role record);

    JsonResponseBody<?> updateByPrimaryKey(Role record);
    /**
     * 查询所有角色
     * @return
     */
    JsonResponseBody<List<Role>> queryRolePagers(PageBean pageBean);

    /**
     * 查询所有角色对应的权限ID
     * @param roleId
     * @return
     */
    JsonResponseBody<List<Integer>> queryPerIdByRole(Integer roleId);

    /**
     * 添加角色对应权限ID
     *
     * @param roleId 角色ID
     *
     * @param perIds 权限ID 数组
     * @return
     */
    JsonResponseBody<?> addPerIdByRolePer(Integer roleId,Integer[] perIds);
}