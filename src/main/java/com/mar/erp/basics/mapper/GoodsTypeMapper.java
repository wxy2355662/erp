package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Long tId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Long tId);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}