package com.mar.erp.sell.service.imp;

import com.mar.erp.sell.mapper.OrderOutDetailsMapper;
import com.mar.erp.sell.model.OrderOutDetails;
import com.mar.erp.sell.service.OrderOutDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class OrderOutDetailsServiceImpl implements OrderOutDetailsService {

    //注入OrderOutDetailsMapper接口
    @Autowired
    private OrderOutDetailsMapper orderOutDetailsMapper;
    @Override
    public List<Map<String, Object>> OrderOutAllpage1(OrderOutDetails orderOutDetails) {
        return orderOutDetailsMapper.OrderOutAllpage1(orderOutDetails);
    }

    @Override
    public int insert(OrderOutDetails record) {
        return orderOutDetailsMapper.insert(record);
    }
}
