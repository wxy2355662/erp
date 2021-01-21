package com.mar.erp.sell.mapper;

import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.model.OrderOut;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OrderOutMapper {
    int deleteByPrimaryKey(Long oId);

     //退货订单添加的方法
    int insert(OrderOut record);

    int insertSelective(OrderOut record);

    OrderOut selectByPrimaryKey(Long oId);

    int updateByPrimaryKeySelective(OrderOut record);

    int updateByPrimaryKey(OrderOut record);

        //查询所有退货订单
        List<Map<String, Object>> OrderOutAllpage(OrderOut orderOut);
        //查询待审核的订单state=0
        List<Map<String, Object>> OrderOutByState(OrderOut orderOut);
        //修改退货订单状态
        int updateState(OrderOut orderOut);
        //查询未通过的订单state=1
        List<Map<String, Object>> OrderOutBySataeOne(OrderOut orderOut);







}