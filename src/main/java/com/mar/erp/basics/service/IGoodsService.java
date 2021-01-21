package com.mar.erp.basics.service;

import com.mar.erp.basics.model.Goods;

import java.util.List;

public interface IGoodsService {

    //根据厂家名字查询所有商品
    List<Goods> selectGoods(Goods goods);

    //根据商品名查询单个
    Goods selectDgGoods(Goods goods);
}