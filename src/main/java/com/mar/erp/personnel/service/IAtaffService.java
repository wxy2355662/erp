package com.mar.erp.personnel.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.personnel.model.Ataff;
import com.mar.erp.personnel.vo.AtaffVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAtaffService {
    JsonResponseBody<?> deleteByPrimaryKey(Long ataId);

    JsonResponseBody<?> insert(Ataff record);

    JsonResponseBody<?> insertSelective(Ataff record);

    JsonResponseBody<Ataff> selectByPrimaryKey(Long ataId);

    JsonResponseBody<?>  updateByPrimaryKeySelective(Ataff record);

    JsonResponseBody<?>  updateByPrimaryKey(Ataff record);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    AtaffVo queryByLogin(String userName);

    /**
     * 判断账号密码是否正确
     * @param userName
     * @param pwd
     * @return
     */
    JsonResponseBody<AtaffVo> userLogin(String userName,String pwd);

    /**
     * 查询所有用户
     * @param ataff
     * @return
     */
    JsonResponseBody<List<Map<String,Object>>> queryAtaffPagers(AtaffVo ataff, PageBean pageBean);

    /**
     * 根据用户id查询对应的角色id
     * @param ataId 用户ID
     * @return
     */
    JsonResponseBody<List<Integer>> queryAtaByRoleId(Long ataId);

    /**
     * 添加用户对应的角色
     * @param ataId
     * @param roleIds
     * @return
     */
    JsonResponseBody<?> addAtaByRoleId(@Param("ataId")Long ataId, @Param("roleIds") Integer[] roleIds);

    /**
     * 根据用户Id删除对应角色
     * @param ataId
     * @return
     */
    JsonResponseBody<?> deleteAtaByAtaId(Long ataId);

    /**
     * 根据用户名查询用户的角色
     * @param ataUserName
     * @return
     */
    Set<String> findRole(String ataUserName);

    /**
     * 根据用户名查询用户角色的权限
     * @param ataUserName
     * @return
     */
    Set<String> findPermissions(String ataUserName);

    /**
     * 验证用户是否存在
     * @param userName
     * @return
     */
    JsonResponseBody<Ataff> verifyUserName(String userName);


    /**
     * 根据邮箱查询账号
     * @param email
     * @return
     */
    JsonResponseBody<Ataff>  findAtaffByEmail(String email);



}