package com.mar.erp.statistic.service;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStatisticService {
    /**
     * 统计报表
     * @param startTime
     * @param endTime
     * @param pageBean
     * @return
     */
    JsonResponseBody<List<Map<String,Object>>> querySalesPagers(String startTime, String endTime, PageBean pageBean);


    /**
     * 获取订单年份
     */

    JsonResponseBody<List<String>>  querySalesYear();

    /**
     * 根据年份查询每个月销售额
     * @param year
     * @return
     */
    JsonResponseBody<List<Map<String,Object>>> querySalesMonthByYearPagers(String year,PageBean pageBean);

    /**
     * 查询每个客户的销售额
     */
    JsonResponseBody<List<Map<String, Object>>> querySalesByClientPagers(String year,PageBean pageBean);

}
