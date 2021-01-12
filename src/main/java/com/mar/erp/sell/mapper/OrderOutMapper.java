package com.mar.erp.sell.mapper;

import com.mar.erp.sell.model.OrderOut;

public interface OrderOutMapper {
    int deleteByPrimaryKey(Long oId);

    int insert(OrderOut record);

    int insertSelective(OrderOut record);

    OrderOut selectByPrimaryKey(Long oId);

    int updateByPrimaryKeySelective(OrderOut record);

    int updateByPrimaryKey(OrderOut record);
}