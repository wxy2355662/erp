package com.mar.erp.sell.service;

import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.model.OrderOut;

import java.util.List;
import java.util.Map;

public interface OrderOutService {
    //查询所有退货订单
    List<Map<String, Object>> OrderOutAllpage(OrderOut orderOut);
    //查询待审核的订单state=1
    List<Map<String, Object>> OrderOutByState(OrderOut orderOut);

    //修改退货订单状态
    int updateState(OrderOut orderOut);
    //查询未通过的订单state=1
    List<Map<String, Object>> OrderOutBySataeOne(OrderOut orderOut);

    //退货订单添加的方法
    int insert(OrderOut record);



}
