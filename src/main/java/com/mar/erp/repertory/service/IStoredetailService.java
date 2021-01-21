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


    //根据出库编号和仓库编号找到库存数量
    Storedetail selectbysrg(Storedetail storedetail);
    //根据出库编号和仓库编号修改到库存数量（出库）
    int updatebysrg(Storedetail storedetail);



}