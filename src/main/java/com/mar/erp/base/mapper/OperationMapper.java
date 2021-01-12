package com.mar.erp.base.mapper;

import com.mar.erp.base.model.Operation;

public interface OperationMapper {
    int deleteByPrimaryKey(Long cId);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long cId);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}