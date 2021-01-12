package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.PurchaseDetails;

public interface PurchaseDetailsMapper {
    int deleteByPrimaryKey(Long piId);

    int insert(PurchaseDetails record);

    int insertSelective(PurchaseDetails record);

    PurchaseDetails selectByPrimaryKey(Long piId);

    int updateByPrimaryKeySelective(PurchaseDetails record);

    int updateByPrimaryKey(PurchaseDetails record);
}