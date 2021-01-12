package com.mar.erp.sys.service.impl;

import com.mar.erp.sys.mapper.PermissionMapper;
import com.mar.erp.sys.model.Permission;
import com.mar.erp.sys.service.IPermissionService;
import com.mar.erp.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer perId) {
        return permissionMapper.deleteByPrimaryKey(perId);
    }

    @Override
    public int insert(Permission record) {

        return permissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {

        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Integer perId) {

        return permissionMapper.selectByPrimaryKey(perId);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {

        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {

        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PermissionVo> queryPrimaryByParent() {

        List<PermissionVo> permissions = permissionMapper.queryPrimaryByParent();
        for (PermissionVo permissionVo : permissions) {
            List<Permission> permissionList = permissionMapper.queryPrimaryByPid(permissionVo.getPerId());
            permissionVo.setPermissionList(permissionList);
        }



        return permissions;
    }


}
