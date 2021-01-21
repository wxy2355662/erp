package com.mar.erp.sell.service.imp;

import com.mar.erp.sell.Vo.OrderListVo;
import com.mar.erp.sell.mapper.OrderListMapper;
import com.mar.erp.sell.mapper.OrderMapper;
import com.mar.erp.sell.model.OrderList;
import com.mar.erp.sell.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderListServiceImpl implements OrderListService {

    //注入orderListMapper接口
    @Autowired
    private OrderListMapper orderListMapper;


    @Override
    public List<Map<String, Object>> OrderListAll(OrderList orderList) {
        return orderListMapper.OrderListAll(orderList);
    }

    @Override
    public int Orderbygoodtype(OrderListVo orderList) {
        return orderListMapper.Orderbygoodtype(orderList);
    }

    @Override
    public int insert(OrderListVo record) {
        return orderListMapper.insert(record);
    }

    @Override
    public int UpdateGoodstate(OrderList orderList) {
        return orderListMapper.UpdateGoodstate(orderList);
    }

}
