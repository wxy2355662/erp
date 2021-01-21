package com.mar.erp.basics.service.impl;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.basics.mapper.StoreMapper;
import com.mar.erp.basics.model.Store;
import com.mar.erp.basics.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public JsonResponseBody<?> selectStore() {
        List<Store> stores = storeMapper.selectStore();
        return new JsonResponseBody<>(stores);
    }


}
