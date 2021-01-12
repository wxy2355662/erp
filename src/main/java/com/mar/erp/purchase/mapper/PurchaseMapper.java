package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Long pId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Long pId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}