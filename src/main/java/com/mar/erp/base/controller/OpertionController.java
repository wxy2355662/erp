package com.mar.erp.base.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.model.Operation;
import com.mar.erp.base.service.IOperationService;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/opertion")
public class OpertionController {

    @Autowired
    private IOperationService operationService;


    @RequestMapping("/queryOpertion")
    @ResponseBody
    public JsonResponseBody<?>  queryOpertion(Operation operation){
        try {
           return  operationService.queryOpertion(operation);
        } catch (Exception e) {
           throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }


    @RequestMapping("/insertSelective")
    @ResponseBody
    public JsonResponseBody<?>  insertSelective(Operation operation){
        try {
            return  operationService.insertSelective(operation);
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_601);
        }
    }




}
