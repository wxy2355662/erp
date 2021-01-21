package com.mar.erp.sys.mapper;

import com.mar.erp.sys.model.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rpId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rpId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    /**
     * 添加角色对应权限
     * @param roleId
     * @param perIds
     * @return
     */
    int addPerIdByRolePer(@Param("roleId")Integer roleId,@Param("perIds")Integer[] perIds);

    /**
     * 根据角色ID删除角色对应的权限
     * @param roleId
     * @return
     */
    int deleteRoleByRoleId(Integer roleId);

    /**
     * 查询是否为最后一个权限管理
     * @return
     */
    List<Integer> queryRoleByquanx();
}