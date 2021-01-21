package com.mar.erp.purchase.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.purchase.model.PurchaseDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPurchaseDetailsService {

    //动态修改订单明细状态
    int updateByPrimaryKeySelective(PurchaseDetails purchaseDetails);


    //添加订单详情
    int insert(PurchaseDetails record);


    //添加订单明细状态为1的
    int insertPurchaseDetails(@Param("purchaseDetailList") List<PurchaseDetails> purchaseDetailList, @Param("piOid") Long piOid);


    //添加订单明细状态为3的
    int insertTousdsDetails(@Param("purchaseDetailList") List<PurchaseDetails> purchaseDetailList, @Param("piOid") Long piOid);


    //根据订单id查询订单明细
    JsonResponseBody<?> queryPuerDetails(PurchaseDetails purchaseDetails);


    PurchaseDetails selectByPrimaryKey(Long piId);

}