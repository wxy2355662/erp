package com.mar.erp.repertory.mapper;

import com.mar.erp.repertory.model.Storedetail;
import com.mar.erp.repertory.vo.StoredetailVo;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredetailMapper {
    int deleteByPrimaryKey(Long sdId);

    int insert(Storedetail record);

    //动态添加库存数据
    int insertSelective(Storedetail storedetail);

    Storedetail selectByPrimaryKey(Long sdId);

    //动态修改
    int updateByPrimaryKeySelective(Storedetail record);


    int updateByPrimaryKey(Storedetail record);


    //查询数据库中库存表
    Storedetail selectStoredetail(StoredetailVo storedetailVo);


    //根据出库编号和仓库编号找到库存数量
    Storedetail selectbysrg(Storedetail storedetail);
    //根据出库编号和仓库编号修改到库存数量（出库）
    int updatebysrg(Storedetail storedetail);



}