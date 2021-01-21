package com.mar.erp.basics.mapper;

import com.mar.erp.basics.model.Curstrumer;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
@RequestMapping
public interface CurstrumerMapper {
    int deleteByPrimaryKey(Long cId);

    int insert(Curstrumer record);

    int insertSelective(Curstrumer record);

    Curstrumer selectByPrimaryKey(Long cId);

    int updateByPrimaryKeySelective(Curstrumer record);

    int updateByPrimaryKey(Curstrumer record);
    //    查询所有的客户
    List<Map<String, Object>> Cursturall();
}