package com.mar.erp.sell.controller;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.sell.mapper.OrderOutDetailsMapper;
import com.mar.erp.sell.model.OrderList;
import com.mar.erp.sell.model.OrderOutDetails;
import com.mar.erp.sell.service.OrderOutDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderOutLiST")
public class OrderOutDetailsController {
    @Autowired
    private OrderOutDetailsService orderOutDetailsService;

    @RequestMapping("/toOrderListAll")
    @ResponseBody
    public JsonResponseBody OrderOUTAllPage(OrderOutDetails orderOutDetails){

        //查询订单
        List<Map<String,Object>> json= orderOutDetailsService.OrderOutAllpage1(orderOutDetails);

        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);
        return  j;
    }





}
