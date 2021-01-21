package com.mar.erp.statistic.controller;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.statistic.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private IStatisticService statisticService;

    /**
     * 销售统计
     * @param startTime
     * @param endTime
     * @param pageBean
     * @return
     */
    @RequestMapping("/querySales")
    public JsonResponseBody querySales(String startTime, String endTime, PageBean pageBean){

        return statisticService.querySalesPagers(startTime,endTime,pageBean);
    }

    @RequestMapping("/querySalesYear")
    public JsonResponseBody querySalesYear(){
        return statisticService.querySalesYear();
    }

    @RequestMapping("/querySalesMonthByYearPagers")
    public JsonResponseBody querySalesMonthByYearPagers(String year,PageBean pageBean){
        return statisticService.querySalesMonthByYearPagers(year,pageBean);
    }

    @RequestMapping("/querySalesByClientPagers")
    public JsonResponseBody querySalesByClientPagers(String year,PageBean pageBean){
        return statisticService.querySalesByClientPagers(year,pageBean);
    }
}
