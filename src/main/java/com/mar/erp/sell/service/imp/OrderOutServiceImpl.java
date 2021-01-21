package com.mar.erp.sell.service.imp;

import com.mar.erp.sell.mapper.OrderOutMapper;
import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.model.OrderOut;
import com.mar.erp.sell.service.OrderOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class OrderOutServiceImpl implements OrderOutService {

    //注入OrderOutMapper接口
    @Autowired
    private OrderOutMapper orderOutMapper;

    @Override
    public List<Map<String, Object>> OrderOutAllpage(OrderOut orderOut) {
        return orderOutMapper.OrderOutAllpage(orderOut);
    }

    @Override
    public List<Map<String, Object>> OrderOutByState(OrderOut orderOut) {
        return orderOutMapper.OrderOutByState(orderOut);
    }

    @Override
    public int updateState(OrderOut orderOut) {
        return orderOutMapper.updateState(orderOut);
    }

    @Override
    public List<Map<String, Object>> OrderOutBySataeOne(OrderOut orderOut) {
        return orderOutMapper.OrderOutBySataeOne(orderOut);
    }

    @Override
    public int insert(OrderOut record) {
        return orderOutMapper.insert(record);
    }
}
