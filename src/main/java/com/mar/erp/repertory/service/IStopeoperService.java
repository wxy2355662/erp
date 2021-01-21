package com.mar.erp.repertory.service;

import com.mar.erp.repertory.model.Stopeoper;

public interface IStopeoperService {

    //动态添加仓库操作记录表
    int insertSelective(Stopeoper record);

}