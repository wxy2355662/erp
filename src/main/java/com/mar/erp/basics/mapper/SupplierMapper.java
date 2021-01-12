package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(Long sId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}