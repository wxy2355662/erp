package com.mar.erp.sell.controller;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.sell.Vo.OrderListVo;
import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.model.OrderList;
import com.mar.erp.sell.service.OrderListService;
import com.mar.erp.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderlist")
public class OrderListController {
    //注入sevice
    @Autowired
    private OrderListService orderListService;

    @RequestMapping("/toOrderListAll")
    @ResponseBody
    public JsonResponseBody OrderAllPage( OrderList orderList){

        //查询订单
        List<Map<String,Object>> json= orderListService.OrderListAll(orderList);
        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);
        return  j;
    }

    //修改订单状态
    @RequestMapping("/toOrderListTYPE")
    @ResponseBody
    public JsonResponseBody Ordertype( OrderListVo orderList){
      int  json= orderListService.Orderbygoodtype(orderList);
      return  null;
    }

    //根据订单id修改订单明细状态
    @RequestMapping("/toOrderListUpdateGoodtype")
    @ResponseBody
    public JsonResponseBody OrderUpdateGoodType( OrderList orderList){

        int  json= orderListService.UpdateGoodstate(orderList);
        System.out.println(json);
        return  null;
    }

}
