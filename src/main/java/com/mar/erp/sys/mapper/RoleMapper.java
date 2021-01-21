package com.mar.erp.sys.mapper;

import com.mar.erp.sys.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> queryRole();

    /**
     * 查询所有角色对应的权限ID
     * @param roleId
     * @return
     */
    List<Integer> queryPerIdByRole(Integer roleId);




}