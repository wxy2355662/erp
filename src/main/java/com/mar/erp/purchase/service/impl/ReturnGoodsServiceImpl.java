package com.mar.erp.purchase.service.impl;

import com.mar.erp.purchase.mapper.ReturnGoodsMapper;
import com.mar.erp.purchase.model.ReturnGoods;
import com.mar.erp.purchase.service.IReturnGoodsService;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.ReturnGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnGoodsServiceImpl implements IReturnGoodsService {

    @Autowired
    private ReturnGoodsMapper returnGoodsMapper;

    @Override
    public List<ReturnGoodsVo> selectGoodsPager(ReturnGoodsVo returnGoodsVo, PageBean pageBean) {
        return returnGoodsMapper.selectGoodsPager(returnGoodsVo);
    }

    @Override
    public List<ReturnGoodsVo> selectGoodsAPager(ReturnGoodsVo returnGoodsVo,PageBean pageBean) {
        return returnGoodsMapper.selectGoodsAPager(returnGoodsVo);
    }

    @Override
    public List<ReturnGoodsVo> selectGoodsBPager(ReturnGoodsVo returnGoodsVo,PageBean pageBean) {
        return returnGoodsMapper.selectGoodsBPager(returnGoodsVo);
    }

    @Override
    public int updateByPrimaryKeySelective(ReturnGoods record) {
        return returnGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ReturnGoods selectReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.selectReturnGoods(returnGoods);
    }

    @Override
    public int insertSelective(ReturnGoods record) {
        return returnGoodsMapper.insertSelective(record);
    }

}
