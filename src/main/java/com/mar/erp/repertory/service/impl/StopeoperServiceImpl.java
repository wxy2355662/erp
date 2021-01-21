package com.mar.erp.repertory.service.impl;

import com.mar.erp.repertory.mapper.StopeoperMapper;
import com.mar.erp.repertory.model.Stopeoper;
import com.mar.erp.repertory.service.IStopeoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StopeoperServiceImpl implements IStopeoperService {

    @Autowired
    private StopeoperMapper stopeoperMapper;

    @Override
    public int insertSelective(Stopeoper record) {
        return stopeoperMapper.insertSelective(record);
    }

}
