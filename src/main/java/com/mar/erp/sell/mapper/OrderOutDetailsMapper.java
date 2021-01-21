package com.mar.erp.sell.mapper;

import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.model.OrderOut;
import com.mar.erp.sell.model.OrderOutDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OrderOutDetailsMapper {
    int deleteByPrimaryKey(Long oroId);


    int insertSelective(OrderOutDetails record);

    OrderOutDetails selectByPrimaryKey(Long oroId);

    int updateByPrimaryKeySelective(OrderOutDetails record);

    int updateByPrimaryKey(OrderOutDetails record);

    //根据订单编号查询该订单的所有订单明细
    List<Map<String, Object>> OrderOutAllpage1(OrderOutDetails orderOutDetails);
    //添加退货订单明细
    int insert(OrderOutDetails record);





}