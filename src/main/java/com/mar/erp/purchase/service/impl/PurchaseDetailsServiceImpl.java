package com.mar.erp.purchase.service.impl;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.purchase.mapper.PurchaseDetailsMapper;
import com.mar.erp.purchase.model.PurchaseDetails;
import com.mar.erp.purchase.service.IPurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseDetailsServiceImpl implements IPurchaseDetailsService {

    @Autowired
    private PurchaseDetailsMapper purchaseDetailsMapper;

    @Override
    public int updateByPrimaryKeySelective(PurchaseDetails purchaseDetails) {
        return purchaseDetailsMapper.updateByPrimaryKeySelective(purchaseDetails);
    }

    @Override
    public int insert(PurchaseDetails record) {
        return purchaseDetailsMapper.insert(record);
    }

    @Override
    public int insertPurchaseDetails(List<PurchaseDetails> purchaseDetailList, Long piOid) {
        return purchaseDetailsMapper.insertPurchaseDetails(purchaseDetailList,piOid);
    }

    @Override
    public int insertTousdsDetails(List<PurchaseDetails> purchaseDetailList, Long piOid) {
        return purchaseDetailsMapper.insertTousdsDetails(purchaseDetailList,piOid);
    }

    @Override
    public JsonResponseBody<?> queryPuerDetails(PurchaseDetails purchaseDetails) {
        List<PurchaseDetails> purchaseDetails1 = purchaseDetailsMapper.queryPuerDetails(purchaseDetails);
        purchaseDetails1.forEach(System.out::println);
        return new JsonResponseBody<>(purchaseDetails1);
    }

    @Override
    public PurchaseDetails selectByPrimaryKey(Long piId) {
        return purchaseDetailsMapper.selectByPrimaryKey(piId);
    }


}
