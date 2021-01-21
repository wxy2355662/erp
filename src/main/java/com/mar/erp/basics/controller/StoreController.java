package com.mar.erp.basics.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.basics.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;


    /**
     * 查询所有仓库
     * @return
     */
    @RequestMapping("/selectStore")
    @ResponseBody
    public JsonResponseBody<?> selectStore(){
        try {
            return storeService.selectStore();
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }

    // 所有出库信息的方法
    @RequestMapping("/StoreAll")
    @ResponseBody
    public JsonResponseBody StoreALL(){
        //查询订单
        List<Map<String,Object>> json= storeService.Storeall();
        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);
        return  j;
    }













}
