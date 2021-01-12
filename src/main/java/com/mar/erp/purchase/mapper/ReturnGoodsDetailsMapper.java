package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.ReturnGoodsDetails;

public interface ReturnGoodsDetailsMapper {
    int deleteByPrimaryKey(Long rgId);

    int insert(ReturnGoodsDetails record);

    int insertSelective(ReturnGoodsDetails record);

    ReturnGoodsDetails selectByPrimaryKey(Long rgId);

    int updateByPrimaryKeySelective(ReturnGoodsDetails record);

    int updateByPrimaryKey(ReturnGoodsDetails record);
}