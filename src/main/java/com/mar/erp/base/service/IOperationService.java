package com.mar.erp.base.service;

import com.mar.erp.base.model.Operation;
import com.mar.erp.base.util.JsonResponseBody;

import java.util.List;

public interface IOperationService {

    //查询操作记录表的数据
    JsonResponseBody<?> queryOpertion(Operation operation);


    //添加操作记录
    JsonResponseBody<?> insertSelective(Operation record);



}