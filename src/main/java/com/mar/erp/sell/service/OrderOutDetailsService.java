package com.mar.erp.sell.service;

import com.mar.erp.sell.model.OrderOutDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 退货订单明细
 */
public interface OrderOutDetailsService {

    //根据订单编号查询该订单的所有订单明细
    List<Map<String, Object>> OrderOutAllpage1(OrderOutDetails orderOutDetails);
    //添加退货订单明细
    int insert(OrderOutDetails record);
}
