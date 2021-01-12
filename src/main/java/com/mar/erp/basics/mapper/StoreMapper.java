package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Long srId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long srId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}