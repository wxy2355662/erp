package com.mar.erp.basics.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.basics.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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













}
