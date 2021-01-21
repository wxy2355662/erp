package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("supplierMapper")
public interface SupplierMapper {
    int deleteByPrimaryKey(Long sId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    //查询全部供应商
    List<Supplier> selectSupplier();

}