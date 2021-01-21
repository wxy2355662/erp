package com.mar.erp.base.mapper;

import com.mar.erp.base.model.Operation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OperationMapper {
    int deleteByPrimaryKey(Long cId);

    int insert(Operation record);

    //添加操作记录
    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long cId);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);

    //查询操作记录表的数据
    List<Operation> queryOpertion(Operation operation);

    //根据订单id查找相应的操作记录
    List<Map<String, Object>> SelectOperationById(Operation operation);






}