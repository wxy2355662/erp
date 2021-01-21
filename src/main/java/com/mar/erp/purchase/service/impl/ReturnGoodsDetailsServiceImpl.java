package com.mar.erp.purchase.service.impl;

import com.mar.erp.purchase.mapper.ReturnGoodsDetailsMapper;
import com.mar.erp.purchase.model.ReturnGoodsDetails;
import com.mar.erp.purchase.service.IReturnGoodsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnGoodsDetailsServiceImpl implements IReturnGoodsDetailsService {

    @Autowired
    private ReturnGoodsDetailsMapper returnGoodsDetailsMapper;

    @Override
    public int updateByPrimaryKeySelective(ReturnGoodsDetails record) {
        return returnGoodsDetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ReturnGoodsDetails> selectDetailsDoods(ReturnGoodsDetails returnGoodsDetails) {
        return returnGoodsDetailsMapper.selectDetailsDoods(returnGoodsDetails);
    }

    @Override
    public ReturnGoodsDetails selectReGoodsDetails(ReturnGoodsDetails returnGoodsDetails) {
        return returnGoodsDetailsMapper.selectReGoodsDetails(returnGoodsDetails);
    }

    @Override
    public int insertSelective(ReturnGoodsDetails record) {
        return returnGoodsDetailsMapper.insertSelective(record);
    }


}

