package com.mar.erp.repertory.mapper;

import com.mar.erp.repertory.model.Storedetail;

public interface StoredetailMapper {
    int deleteByPrimaryKey(Long sdId);

    int insert(Storedetail record);

    int insertSelective(Storedetail record);

    Storedetail selectByPrimaryKey(Long sdId);

    int updateByPrimaryKeySelective(Storedetail record);

    int updateByPrimaryKey(Storedetail record);
}