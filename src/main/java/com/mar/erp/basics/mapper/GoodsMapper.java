package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("goodsMapper")
public interface GoodsMapper {
    int deleteByPrimaryKey(Long gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long gId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);


    //根据厂家名字查询所有商品
    List<Goods> selectGoods(Goods goods);

    //根据商品名查询单个
    Goods selectDgGoods(Goods goods);


    //    查询所有的商品
    List<Map<String, Object>> Goodsall();

    //查询单个商品
    Goods GoodsBYID(Goods goods);

}