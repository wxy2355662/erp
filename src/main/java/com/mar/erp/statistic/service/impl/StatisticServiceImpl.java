package com.mar.erp.statistic.service.impl;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.statistic.service.IStatisticService;
import com.mar.erp.sys.mapper.AtaffRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements IStatisticService {

    @Autowired
    private AtaffRoleMapper ataffRoleMapper;

    @Override
    public JsonResponseBody<List<Map<String, Object>>> querySalesPagers(String startTime, String endTime, PageBean pageBean) {
        List<Map<String, Object>> maps = ataffRoleMapper.querySales(startTime, endTime);

        if(maps.size()<1){
            throw  new BusinessException(ResponseStatus.STATUS_602);
        }

        return new JsonResponseBody<>(maps);
    }

    @Override
    public JsonResponseBody<List<String>> querySalesYear() {

        return new JsonResponseBody<>(ataffRoleMapper.querySalesYear());
    }

    @Override
    public JsonResponseBody<List<Map<String, Object>>> querySalesMonthByYearPagers(String year, PageBean pageBean) {
        return new JsonResponseBody<>(ataffRoleMapper.querySalesMonthByYear(year));
    }

    @Override
    public JsonResponseBody<List<Map<String, Object>>> querySalesByClientPagers(String year, PageBean pageBean) {
        return new JsonResponseBody<>(ataffRoleMapper.querySalesByClient(year));
    }
}
