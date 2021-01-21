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



}