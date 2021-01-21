package com.mar.erp.sys.service;

import com.mar.erp.sys.model.Permission;
import com.mar.erp.sys.vo.PermissionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPermissionService {
    int deleteByPrimaryKey(Integer perId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 找到所有父节点
     * @return
     */
    List<PermissionVo> queryPrimaryByParent();

    /**
     * 根据父节点找到所有父节点下的子节点
     * @return
     */
    List<PermissionVo>  queryPrimaryByPid(Integer pid);

    /**
     * 根据用户名查询到用户下所有的根节点 为空查询所有
     * @param userName
     * @return
     */
    List<PermissionVo> findPrimaryByUserName(String userName);

    /**
     * 根据用户名查询到用户下根节点的子节点 为空查询所有
     * @param userName 用户名
     * @param perId  父节点id
     * @return
     */
    List<PermissionVo> findPrimaryByPerId(@Param("userName") String userName,
                                        @Param("perId") Integer perId);




}