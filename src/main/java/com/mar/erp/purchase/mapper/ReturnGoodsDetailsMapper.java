package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.ReturnGoodsDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface ReturnGoodsDetailsMapper {
    int deleteByPrimaryKey(Long rgId);

    int insert(ReturnGoodsDetails record);


    ReturnGoodsDetails selectByPrimaryKey(Long rgId);

    //动态修改订单状态
    int updateByPrimaryKeySelective(ReturnGoodsDetails record);

    int updateByPrimaryKey(ReturnGoodsDetails record);

    //根据订单编号查询订单详情
    List<ReturnGoodsDetails> selectDetailsDoods(ReturnGoodsDetails returnGoodsDetails);

    //根据采购订单编号查询退货订单
    ReturnGoodsDetails selectReGoodsDetails(ReturnGoodsDetails returnGoodsDetails);

    //动态生成退货订单明细数据
    int insertSelective(ReturnGoodsDetails record);


}