package com.mar.erp.purchase.mapper;

import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.vo.PurchaseVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("purchaseMapper")
public interface PurchaseMapper {
    int deleteByPrimaryKey(Long pId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Long pId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    //分页
    List<Purchase> queryPurchasePager(PurchaseVo purchaseVo);
}