package com.mar.erp.base.service.impl;

import com.mar.erp.base.mapper.OperationMapper;
import com.mar.erp.base.model.Operation;
import com.mar.erp.base.service.IOperationService;
import com.mar.erp.base.util.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IOperationServiceImpl implements IOperationService {

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public JsonResponseBody<?> queryOpertion(Operation operation) {
        List<Operation> operations = operationMapper.queryOpertion(operation);
        return new JsonResponseBody<>(operations);
    }

    @Override
    public JsonResponseBody<?> insertSelective(Operation record) {
        int i = operationMapper.insertSelective(record);
        return new JsonResponseBody<>(i);
    }


    @Override
    public int insert(Operation record) {
        return operationMapper.insert(record);
    }

    @Override
    public List<Map<String, Object>> SelectOperationById(Operation operation) {
        return operationMapper.SelectOperationById(operation);
    }


}
