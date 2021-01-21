package com.mar.erp.basics.controller;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.basics.service.ICurstrumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Curstrumerall")
public class CurstrumerController {
    @Autowired
    private ICurstrumerService curstrumerService;


    @RequestMapping("/Curstrall")
    @ResponseBody
    public JsonResponseBody StoreALL(){
        //查询订单
        List<Map<String,Object>> json= curstrumerService.Storeall();
//        System.out.println(json);
        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);

        return  j;
    }

}
