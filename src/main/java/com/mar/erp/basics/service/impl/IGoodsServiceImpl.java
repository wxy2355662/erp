package com.mar.erp.basics.service.impl;

import com.mar.erp.basics.mapper.GoodsMapper;
import com.mar.erp.basics.model.Goods;
import com.mar.erp.basics.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IGoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectGoods(Goods goods) {
        return goodsMapper.selectGoods(goods);
    }

    @Override
    public Goods selectDgGoods(Goods goods) {
        return goodsMapper.selectDgGoods(goods);
    }


}
