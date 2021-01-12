package com.mar.erp.sell.mapper;

import com.mar.erp.sell.model.OrderList;

public interface OrderListMapper {
    int deleteByPrimaryKey(Long olId);

    int insert(OrderList record);

    int insertSelective(OrderList record);

    OrderList selectByPrimaryKey(Long olId);

    int updateByPrimaryKeySelective(OrderList record);

    int updateByPrimaryKey(OrderList record);
}