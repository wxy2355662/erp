package com.mar.erp.sys.mapper;

import com.mar.erp.sys.model.AtaffRole;

public interface AtaffRoleMapper {
    int deleteByPrimaryKey(Integer arId);

    int insert(AtaffRole record);

    int insertSelective(AtaffRole record);

    AtaffRole selectByPrimaryKey(Integer arId);

    int updateByPrimaryKeySelective(AtaffRole record);

    int updateByPrimaryKey(AtaffRole record);
}