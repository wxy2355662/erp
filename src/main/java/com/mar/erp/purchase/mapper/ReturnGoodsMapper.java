package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.ReturnGoods;

public interface ReturnGoodsMapper {
    int deleteByPrimaryKey(Long rId);

    int insert(ReturnGoods record);

    int insertSelective(ReturnGoods record);

    ReturnGoods selectByPrimaryKey(Long rId);

    int updateByPrimaryKeySelective(ReturnGoods record);

    int updateByPrimaryKey(ReturnGoods record);
}