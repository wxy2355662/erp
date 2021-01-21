package com.mar.erp.purchase.service.impl;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.purchase.mapper.PurchaseDetailsMapper;
import com.mar.erp.purchase.mapper.PurchaseMapper;
import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.model.PurchaseDetails;
import com.mar.erp.purchase.service.IPurchaseService;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private PurchaseDetailsMapper purchaseDetailsMapper;


    @Override
    public int insert(Purchase record) {
        return purchaseMapper.insert(record);
    }

    @Override
    public List<Purchase> queryPurchasePager(PurchaseVo purchaseVo, PageBean pageBean) {
        return purchaseMapper.queryPurchasePager(purchaseVo);
    }

    @Override
    public List<Purchase> queryPurchaseAPager(Purchase purchase, PageBean pageBean) {
        List<Purchase> purchases = purchaseMapper.queryPurchasePager1(purchase);
        return purchases;
    }

    @Override
    public JsonResponseBody<?> queryPurchasePager2(PurchaseVo purchaseVo,PageBean pageBean) {
        List<Purchase> purchases = purchaseMapper.queryPurchasePager2(purchaseVo);
        return new JsonResponseBody<List<Purchase>>(purchases);
    }

    @Override
    public List<Purchase> queryPurchaseCPager(PurchaseVo purchaseVo,PageBean pageBean) {
        List<Purchase> purchases = purchaseMapper.queryPurchaseCPager(purchaseVo);
        return purchases;
    }

    @Override
    public JsonResponseBody<?> updateByPurchase(Purchase purchase) {
        int i = purchaseMapper.updateByPurchase(purchase);
        return new JsonResponseBody<>(i);
    }


    /**
     * 添加订单和订单明细
     * @param record
     * @return
     */
    @Transactional
    @Override
    public JsonResponseBody<?> insertSelective(Purchase record) {

        //添加订单
        int piOid = purchaseMapper.insertSelective(record);
//        System.out.println(record.getPurchaseList());
//        System.out.println(record.getpId());
//        System.out.println("------------------------------>"+piOid);

        //添加订单明细
        int details = purchaseDetailsMapper.insertPurchaseDetails(record.getPurchaseList(), record.getpId());
//        System.out.println("-------------------->"+details);

        if(piOid==0 && details==0){
            return new JsonResponseBody<>(ResponseStatus.STATUS_601);
        }

        return new JsonResponseBody<>();
    }

    @Override
    public Purchase selectByPrimaryKey(Long pId) {
        return purchaseMapper.selectByPrimaryKey(pId);
    }

    @Override
    public int updateByPrimaryKeySelective(Purchase record) {
        return purchaseMapper.updateByPrimaryKeySelective(record);
    }


}
