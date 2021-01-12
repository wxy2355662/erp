package com.mar.erp.personnel.mapper;

import com.mar.erp.personnel.model.Ataff;

public interface AtaffMapper {
    int deleteByPrimaryKey(Long ataId);

    int insert(Ataff record);

    int insertSelective(Ataff record);

    Ataff selectByPrimaryKey(Long ataId);

    int updateByPrimaryKeySelective(Ataff record);

    int updateByPrimaryKey(Ataff record);
}