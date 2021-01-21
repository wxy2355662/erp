package com.mar.erp.sys.controller;


import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.sys.model.Role;
import com.mar.erp.sys.service.IRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    /**
     * 添加角色
     * @param role 被添加的角色
     * @return
     */
    @RequiresPermissions("system:role:add")
    @RequestMapping("/addRole")
    public JsonResponseBody addRole(Role role){
        JsonResponseBody<?> jsonResponseBody = roleService.insert(role);
        return jsonResponseBody;
    }

    /**
     * 删除角色
     * @param role
     * @return
     */
    @RequiresPermissions("system:role:del")
    @RequestMapping("/delRole")
    public JsonResponseBody delRole(Role role){
        return roleService.deleteByPrimaryKey(role.getRoleId());
    }

    /**
     * 根据参数修改角色
     * @param role
     * @return
     */
    @RequiresPermissions("system:role:upd")
    @RequestMapping("/updRole")
    public JsonResponseBody updRole(Role role){
        return roleService.updateByPrimaryKeySelective(role);
    }

    /**
     * 查询所有角色信息
     * @return
     */

    @RequiresPermissions(value = {"system:role:query","system:user:query"},logical = Logical.OR)
    @RequestMapping("/queryRole")
    public JsonResponseBody queryRole(PageBean pageBean){
        return roleService.queryRolePagers(pageBean);
    }

   @RequestMapping("/queryPerIdByRole")
    public JsonResponseBody queryPerIdByRole(Role role){

       return roleService.queryPerIdByRole(role.getRoleId());
    }

    @RequiresPermissions("system:role:per")
    @RequestMapping("/addPerIdByRolePer")
    public JsonResponseBody addPerIdByRolePer(Integer roleId, Integer[] moduleId){
        return roleService.addPerIdByRolePer(roleId,moduleId);
    }


}
