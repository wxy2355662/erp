package com.mar.erp.base.service;

import com.mar.erp.base.model.Operation;
import com.mar.erp.base.util.JsonResponseBody;

import java.util.List;
import java.util.Map;

public interface IOperationService {

    //查询操作记录表的数据
    JsonResponseBody<?> queryOpertion(Operation operation);


    //添加操作记录
    JsonResponseBody<?> insertSelective(Operation record);


    //操作记录添加方法
    int insert(Operation record);
    //根据订单id查找相应的操作记录
    List<Map<String, Object>> SelectOperationById(Operation operation);



}