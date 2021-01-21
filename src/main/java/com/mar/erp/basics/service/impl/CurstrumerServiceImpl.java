package com.mar.erp.basics.service.impl;

import com.mar.erp.basics.mapper.CurstrumerMapper;
import com.mar.erp.basics.service.ICurstrumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class CurstrumerServiceImpl implements ICurstrumerService {
    @Autowired
    private CurstrumerMapper curstrumerMapper;

    public List<Map<String, Object>> Storeall() {
        return curstrumerMapper.Cursturall();
    }
}
