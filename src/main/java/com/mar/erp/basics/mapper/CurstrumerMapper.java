package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Curstrumer;

public interface CurstrumerMapper {
    int deleteByPrimaryKey(Long cId);

    int insert(Curstrumer record);

    int insertSelective(Curstrumer record);

    Curstrumer selectByPrimaryKey(Long cId);

    int updateByPrimaryKeySelective(Curstrumer record);

    int updateByPrimaryKey(Curstrumer record);
}