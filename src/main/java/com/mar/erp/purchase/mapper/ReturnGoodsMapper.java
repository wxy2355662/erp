package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.ReturnGoods;
import com.mar.erp.purchase.vo.ReturnGoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnGoodsMapper {
    int deleteByPrimaryKey(Long rId);

    int insert(ReturnGoods record);

    ReturnGoods selectByPrimaryKey(Long rId);

    int updateByPrimaryKey(ReturnGoods record);


    //退货订单查询
    List<ReturnGoodsVo> selectGoodsPager(ReturnGoodsVo returnGoodsVo);


    //查询退货订单为1的未审核订单
    List<ReturnGoodsVo> selectGoodsAPager(ReturnGoodsVo returnGoodsVo);


    //查询退货订单为2的已审核订单
    List<ReturnGoodsVo> selectGoodsBPager(ReturnGoodsVo returnGoodsVo);


    //动态修改订单状态
    int updateByPrimaryKeySelective(ReturnGoods record);


    //根据采购订单编号查询单个退货订单
    ReturnGoods selectReturnGoods(ReturnGoods returnGoods);


    //动态新增退货订单
    int insertSelective(ReturnGoods record);



}
