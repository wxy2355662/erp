package com.mar.erp.purchase.service;

import com.mar.erp.purchase.model.ReturnGoodsDetails;

import java.util.List;

public interface IReturnGoodsDetailsService {

    //动态修改订单状态
    int updateByPrimaryKeySelective(ReturnGoodsDetails record);

    //根据订单编号查询订单详情
    List<ReturnGoodsDetails> selectDetailsDoods(ReturnGoodsDetails returnGoodsDetails);

    //根据采购订单编号查询退货订单
    ReturnGoodsDetails selectReGoodsDetails(ReturnGoodsDetails returnGoodsDetails);

    //动态生成退货订单明细数据
    int insertSelective(ReturnGoodsDetails record);

}