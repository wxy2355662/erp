package com.mar.erp.sell.service;

import com.mar.erp.base.util.PageBean;
import com.mar.erp.sell.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    //查询所有订单+分页+模糊查询
    List<Map<String, Object>> OrderAllpage(Order order, PageBean pageBean);

    //查询所有订单+分页+模糊查询 (已发货)
    List<Map<String, Object>> OrderAllpage1(Order order,PageBean pageBean);
    //查询单个订单
    Order Orderbyid( Long orderId);
    //修改订单状态
    int  Order_type(Order order);
    //添加订单
    Long insert(Order record);
}
