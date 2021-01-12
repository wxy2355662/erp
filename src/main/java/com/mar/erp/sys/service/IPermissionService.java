package com.mar.erp.sys.service;

import com.mar.erp.sys.model.Permission;
import com.mar.erp.sys.vo.PermissionVo;
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




}