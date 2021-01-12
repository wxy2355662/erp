package com.mar.erp.sell.mapper;

import com.mar.erp.sell.model.OrderOutDetails;

public interface OrderOutDetailsMapper {
    int deleteByPrimaryKey(Long oroId);

    int insert(OrderOutDetails record);

    int insertSelective(OrderOutDetails record);

    OrderOutDetails selectByPrimaryKey(Long oroId);

    int updateByPrimaryKeySelective(OrderOutDetails record);

    int updateByPrimaryKey(OrderOutDetails record);
}