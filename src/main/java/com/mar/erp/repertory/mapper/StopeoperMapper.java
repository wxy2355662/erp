package com.mar.erp.repertory.mapper;

import com.mar.erp.repertory.model.Stopeoper;
import org.springframework.stereotype.Repository;

@Repository
public interface StopeoperMapper {
    int deleteByPrimaryKey(Long stId);

    int insert(Stopeoper record);

    Stopeoper selectByPrimaryKey(Long stId);

    int updateByPrimaryKeySelective(Stopeoper record);

    int updateByPrimaryKey(Stopeoper record);

    //动态添加仓库操作记录表
    int insertSelective(Stopeoper record);

}