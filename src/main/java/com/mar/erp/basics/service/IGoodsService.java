package com.mar.erp.basics.service;

import com.mar.erp.basics.model.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsService {

    //根据厂家名字查询所有商品
    List<Goods> selectGoods(Goods goods);

    //根据商品名查询单个
    Goods selectDgGoods(Goods goods);


    //    查询所有的商品
    List<Map<String, Object>> Goodsall();
    //查询单个商品
    Goods GoodsBYID(Goods goods);
}