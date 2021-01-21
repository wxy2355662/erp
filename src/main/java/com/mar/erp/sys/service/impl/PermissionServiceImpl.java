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
        //查询到所有父节点
        List<PermissionVo> permissions = permissionMapper.queryPrimaryByParent();
        //遍历所有父节点
        for (PermissionVo permissionVo : permissions) {
            //根据父节点ID查询到所有的子节点（枝节点，叶节点）
            List<PermissionVo> permissionList = queryPrimaryByPid(permissionVo.getPerId());
            //把查到的子节点set进入父节点
            permissionVo.setPermissionList(permissionList);
        }

        return permissions;
    }

    @Override
    public List<PermissionVo> queryPrimaryByPid(Integer pid) {
        //根据父节点ID查询到所有子节点
        List<PermissionVo> permissionVos = permissionMapper.queryPrimaryByPid(pid);
        //遍历所有子节点(判断是否有叶节点，有就继续遍历,没有不会进入循环因为数据库返回的是“[]”,最好做个非空判断)
        for (PermissionVo permissionVo : permissionVos) {
            //调用递归继续查找枝节点下面的叶节点
            List<PermissionVo> permissionVoList = queryPrimaryByPid(permissionVo.getPerId());
            //将叶节点赋值枝节点
            permissionVo.setPermissionList(permissionVoList);
        }
        //返回子节点
        return permissionVos;
    }


    @Override
    public List<PermissionVo> findPrimaryByUserName(String userName) {
        //查询到用户所有父节点
        List<PermissionVo> primaryByUserName = permissionMapper.findPrimaryByUserName(userName);
        for (PermissionVo permissionVo : primaryByUserName) {
            //根据用户名和父节点id查询到所有子节点
            List<PermissionVo> primaryByPerId = permissionMapper.findPrimaryByPerId(userName, permissionVo.getPerId());
            //把子节点赋值进入父节点
            permissionVo.setPermissionList(primaryByPerId);
        }
        //因为用户不需要带权限进入前端，只需要带页面进入前端，所以不用再往下找，如果有需要可以继续递归
        return primaryByUserName;
    }

    @Override
    public List<PermissionVo> findPrimaryByPerId(String userName, Integer perId) {
        return permissionMapper.findPrimaryByPerId(userName,perId);
    }


}
