package com.mar.erp.repertory.service.impl;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.repertory.mapper.StoredetailMapper;
import com.mar.erp.repertory.model.Storedetail;
import com.mar.erp.repertory.service.IStoredetailService;
import com.mar.erp.repertory.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoredetailServiceImpl implements IStoredetailService {

    @Autowired
    private StoredetailMapper storedetailMapper;

    @Override
    public int updateByPrimaryKeySelective(Storedetail storedetail) {
        return storedetailMapper.updateByPrimaryKeySelective(storedetail);
    }

    @Override
    public int insertSelective(Storedetail storedetail) {
        return storedetailMapper.insertSelective(storedetail);
    }

    @Override
    public Storedetail selectStoredetail(StoredetailVo storedetailVo) {
        Storedetail sto = storedetailMapper.selectStoredetail(storedetailVo);
        return sto;
    }



}
