package com.mar.erp.basics.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.basics.model.Store;

import java.util.List;
import java.util.Map;

public interface IStoreService {

    //查询所有的仓库
    JsonResponseBody<?> selectStore();

    //查询所有仓库
    List<Map<String,Object>> Storeall ();


}