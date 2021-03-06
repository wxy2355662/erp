package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMapper {
    int deleteByPrimaryKey(Long srId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long srId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    //查询所有的仓库
    List<Store> selectStore();

    //查询所有仓库
    List<Map<String,Object>> Storeall ();







}