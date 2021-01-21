package com.mar.erp.sell.service;

import com.mar.erp.sell.Vo.OrderListVo;
import com.mar.erp.sell.model.OrderList;

import java.util.List;
import java.util.Map;

/**
 * 订单明细
 */
public interface OrderListService {
    //查询单个订单明细
    List<Map<String, Object>> OrderListAll(OrderList orderList);

    //修改商品状态
    int  Orderbygoodtype(OrderListVo orderList);

    //添加订单明细
    int insert(OrderListVo record);

    //根据订单id修改订单明细状态
    int UpdateGoodstate(OrderList orderList);


}
