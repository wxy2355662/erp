package com.mar.erp.basics.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.basics.model.Store;

import java.util.List;

public interface IStoreService {

    //查询所有的仓库
    JsonResponseBody<?> selectStore();


}