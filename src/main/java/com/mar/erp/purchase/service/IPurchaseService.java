package com.mar.erp.purchase.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.PurchaseVo;

import java.util.List;
import java.util.Map;


public interface IPurchaseService {

    //添加订单
    int insert(Purchase record);


    // 采购订单分页
    List<Purchase> queryPurchasePager(PurchaseVo purchaseVo, PageBean pageBean);


    //查询所有状态为1的未审核订单
    List<Purchase> queryPurchaseAPager(Purchase purchase, PageBean pageBean);


    //查询所有状态为2的已审核的订单
    JsonResponseBody<?> queryPurchasePager2(PurchaseVo purchaseVo, PageBean pageBean);


    //查询所有订单状态为3的已确认的订单
    List<Purchase> queryPurchaseCPager(PurchaseVo purchaseVo,PageBean pageBean);


    //修改订单状态
    JsonResponseBody<?> updateByPurchase(Purchase purchase);


    //动态添加订单
    JsonResponseBody<?> insertSelective(Purchase record);


    //根据订单编号查询单个
    Purchase selectByPrimaryKey(Long pId);


    //动态修改订单金额
    int updateByPrimaryKeySelective(Purchase record);


}