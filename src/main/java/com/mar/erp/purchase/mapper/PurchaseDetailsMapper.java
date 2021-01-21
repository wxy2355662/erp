package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.PurchaseDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("purchaseDetailsMapper")
public interface PurchaseDetailsMapper {
    int deleteByPrimaryKey(Long piId);

    int insert(PurchaseDetails record);

    int insertSelective(PurchaseDetails record);

    PurchaseDetails selectByPrimaryKey(Long piId);

    //动态修改订单明细状态
    int updateByPrimaryKeySelective(PurchaseDetails record);

    int updateByPrimaryKey(PurchaseDetails record);

    //添加订单明细状态为1的
    int insertPurchaseDetails(@Param("purchaseDetailList") List<PurchaseDetails> purchaseDetailList, @Param("piOid") Long piOid);


    //添加订单明细状态为3的
    int insertTousdsDetails(@Param("purchaseDetailList") List<PurchaseDetails> purchaseDetailList, @Param("piOid") Long piOid);


    //根据订单id查询订单明细
    List<PurchaseDetails> queryPuerDetails(PurchaseDetails purchaseDetails);




}