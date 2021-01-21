package com.mar.erp.sys.service.impl;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.sys.mapper.RoleMapper;
import com.mar.erp.sys.mapper.RolePermissionMapper;
import com.mar.erp.sys.model.Role;
import com.mar.erp.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public JsonResponseBody<?> deleteByPrimaryKey(Integer roleId) {
        if(roleId==1){
            throw new BusinessException(ResponseStatus.STATUS_611);
        }

        int i = roleMapper.deleteByPrimaryKey(roleId);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_603);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> insert(Role record) {
        int i = roleMapper.insert(record);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_601);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> insertSelective(Role record) {
        int i = roleMapper.insertSelective(record);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_601);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<Role> selectByPrimaryKey(Integer roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if(role==null){
            return new JsonResponseBody<>(ResponseStatus.STATUS_602);
        }

        return new JsonResponseBody<>(role);
    }

    @Override
    public JsonResponseBody<?> updateByPrimaryKeySelective(Role record) {
        int i = roleMapper.updateByPrimaryKeySelective(record);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> updateByPrimaryKey(Role record) {
        int i = roleMapper.updateByPrimaryKey(record);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<List<Role>> queryRolePagers(PageBean pageBean) {
        List<Role> roles = roleMapper.queryRole();
        if(roles.size()<1){
            return new JsonResponseBody<>(ResponseStatus.STATUS_602);
        }
        return new JsonResponseBody<>(roles);
    }

    @Override
    public JsonResponseBody<List<Integer>> queryPerIdByRole(Integer roleId) {
        List<Integer> integers = roleMapper.queryPerIdByRole(roleId);
        if(integers.size()<1){
            return new JsonResponseBody<>(ResponseStatus.STATUS_602);
        }
        return new JsonResponseBody<>(integers);
    }

    @Transactional
    @Override
    public JsonResponseBody<?> addPerIdByRolePer(Integer roleId, Integer[] perIds) {
        if(roleId==1){
            throw new BusinessException(ResponseStatus.STATUS_611);
        }

        rolePermissionMapper.deleteRoleByRoleId(roleId);
        int i = rolePermissionMapper.addPerIdByRolePer(roleId, perIds);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_601);
        }

        return new JsonResponseBody<>();
    }


}
