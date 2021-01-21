package com.mar.erp.purchase.service;

import com.mar.erp.purchase.model.ReturnGoods;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.ReturnGoodsVo;

import java.util.List;

public interface IReturnGoodsService {


    //退货订单查询
    List<ReturnGoodsVo> selectGoodsPager(ReturnGoodsVo returnGoodsVo,PageBean pageBean);


    //查询退货订单为1的未审核订单
    List<ReturnGoodsVo> selectGoodsAPager(ReturnGoodsVo returnGoodsVo,PageBean pageBean);


    //查询退货订单为2的已审核订单
    List<ReturnGoodsVo> selectGoodsBPager(ReturnGoodsVo returnGoodsVo,PageBean pageBean);


    //动态修改订单状态为2已审核
    int updateByPrimaryKeySelective(ReturnGoods record);


    //根据采购订单编号查询单个退货订单
    ReturnGoods selectReturnGoods(ReturnGoods returnGoods);


    //动态新增退货订单
    int insertSelective(ReturnGoods record);


}
