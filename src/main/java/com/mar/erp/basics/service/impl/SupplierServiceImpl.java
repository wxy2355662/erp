package com.mar.erp.basics.service.impl;

import com.mar.erp.basics.mapper.SupplierMapper;
import com.mar.erp.basics.model.Supplier;
import com.mar.erp.basics.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> selectSupplier() {
        return supplierMapper.selectSupplier();
    }
}
