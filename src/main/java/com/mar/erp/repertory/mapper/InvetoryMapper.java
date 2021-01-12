package com.mar.erp.repertory.mapper;

import com.mar.erp.repertory.model.Invetory;

public interface InvetoryMapper {
    int deleteByPrimaryKey(Long iId);

    int insert(Invetory record);

    int insertSelective(Invetory record);

    Invetory selectByPrimaryKey(Long iId);

    int updateByPrimaryKeySelective(Invetory record);

    int updateByPrimaryKey(Invetory record);
}