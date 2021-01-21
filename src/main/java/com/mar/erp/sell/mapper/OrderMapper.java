package com.mar.erp.sell.mapper;

import com.mar.erp.base.util.PageBean;
import com.mar.erp.sell.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    //添加订单
    Long insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //查询所有订单+分页+模糊查询
    List<Map<String, Object>> OrderAllpage(Order order);

    //查询所有订单+分页+模糊查询 (已发货)已经退货
    List<Map<String, Object>> OrderAllpage1(Order order);

    //查询单个订单
    Order Orderbyid( Long orderId);

    //修改订单状态
    int  Order_type(Order order);


}