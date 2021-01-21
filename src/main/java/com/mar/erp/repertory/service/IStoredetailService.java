package com.mar.erp.repertory.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.repertory.model.Storedetail;
import com.mar.erp.repertory.vo.StoredetailVo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IStoredetailService {


    //动态修改
    int updateByPrimaryKeySelective(Storedetail storedetail);

    //动态添加库存数据
    int insertSelective(Storedetail storedetail);


    //查询数据库中库存表
    Storedetail selectStoredetail(StoredetailVo storedetailVo);



}