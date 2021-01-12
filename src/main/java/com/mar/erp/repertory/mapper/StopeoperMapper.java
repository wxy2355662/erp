package com.mar.erp.repertory.mapper;

import com.mar.erp.repertory.model.Stopeoper;

public interface StopeoperMapper {
    int deleteByPrimaryKey(Long stId);

    int insert(Stopeoper record);

    int insertSelective(Stopeoper record);

    Stopeoper selectByPrimaryKey(Long stId);

    int updateByPrimaryKeySelective(Stopeoper record);

    int updateByPrimaryKey(Stopeoper record);
}