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

import java.util.List;
import java.util.Map;

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

    //添加操作记录的方法
    @RequestMapping("/toAddoperation")
    @ResponseBody
    public JsonResponseBody OrderOutState(Operation operation){

        try {
            System.out.println("添加"+operation);

            //查询订单
            int json= operationService.insert(operation);
            JsonResponseBody jsonResponseBody=new JsonResponseBody();

            jsonResponseBody.setMsg("ok");
            return jsonResponseBody;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_601);
        }

    }



    //根据订单编号查询订单的所有信息
    @RequestMapping("/toSelectOperationByid")
    @ResponseBody
    public JsonResponseBody OrderOutStateoOne(Operation operation){


        //查询订单
        List<Map<String,Object>> json= operationService.SelectOperationById(operation);


        System.out.println("查询查询"+json);


        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);
        return  j;
    }




}
