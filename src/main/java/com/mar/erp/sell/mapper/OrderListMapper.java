package com.mar.erp.sell.mapper;

import com.mar.erp.sell.Vo.OrderListVo;
import com.mar.erp.sell.model.OrderList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderListMapper {
    int deleteByPrimaryKey(Long olId);

    int insertSelective(OrderList record);

    OrderList selectByPrimaryKey(Long olId);

    int updateByPrimaryKeySelective(OrderList record);

    int updateByPrimaryKey(OrderList record);


    //添加订单明细（自动生成）
    int insert(OrderListVo record);

    //查询单个订单明细
    List<Map<String, Object>> OrderListAll(OrderList orderList);

    //修改商品状态（为已经出库）
    int  Orderbygoodtype(OrderListVo orderList);

    //根据订单id修改订单明细状态
    int UpdateGoodstate(OrderList orderList);






}