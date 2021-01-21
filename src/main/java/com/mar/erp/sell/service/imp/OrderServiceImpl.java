package com.mar.erp.sell.service.imp;

import com.mar.erp.base.util.PageBean;
import com.mar.erp.sell.mapper.OrderMapper;
import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    //注入OrderMapper层的接口
    @Autowired
    private OrderMapper orderMapper;



    @Override
    public List<Map<String, Object>> OrderAllpage(Order order, PageBean pageBean) {

        return orderMapper.OrderAllpage(order);
    }

    @Override
    public List<Map<String, Object>> OrderAllpage1(Order order, PageBean pageBean) {
        return orderMapper.OrderAllpage1(order);
    }

    @Override
    public Order Orderbyid(Long orderId) {
        return orderMapper.Orderbyid(orderId);
    }

    @Override
    public int Order_type(Order order) {
        return orderMapper.Order_type(order);
    }

    @Override
    public Long insert(Order record) {
        return orderMapper.insert(record);
    }
}
