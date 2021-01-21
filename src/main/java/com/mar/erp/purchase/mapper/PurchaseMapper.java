package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.vo.PurchaseVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("purchaseMapper")
public interface PurchaseMapper {
    int deleteByPrimaryKey(Long pId);

    int insert(Purchase record);

    //动态添加订单
    int insertSelective(Purchase record);

    //根据订单编号查询单个
    Purchase selectByPrimaryKey(Long pId);

    //动态修改订单金额
    int updateByPrimaryKeySelective(Purchase record);


    int updateByPrimaryKey(Purchase record);


    //修改订单状态
    int updateByPurchase(Purchase purchase);

    //分页
    List<Purchase> queryPurchasePager(PurchaseVo purchaseVo);


    //查询所有状态为1的未审核订单
    List<Purchase> queryPurchasePager1(Purchase purchase);


    //查询所有状态为2的已审核的订单
    List<Purchase> queryPurchasePager2(PurchaseVo purchaseVo);


    //查询所有状态为3的已确认的订单
    List<Purchase> queryPurchaseCPager(PurchaseVo purchaseVo);




}