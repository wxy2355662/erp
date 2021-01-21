package com.mar.erp.sell.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.sell.Vo.OrderListVo;
import com.mar.erp.sell.model.Order;
import com.mar.erp.sell.model.OrderList;
import com.mar.erp.sell.service.OrderListService;
import com.mar.erp.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    //注入sevice
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderListService orderListService;
    // 查询未出库的方法
    @RequestMapping("/toOrderAll")
    @ResponseBody
    public JsonResponseBody OrderAllPage(HttpServletRequest request, Order order){
        //创建pageBean
        PageBean pageBean=new PageBean();
        //初始化
        pageBean.setRequest(request);
        //查询订单
        List<Map<String,Object>> json= orderService.OrderAllpage(order,pageBean);
        System.out.println(json);
        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 页码
        j.setTotal(pageBean.getTotal());
        // 数据
        j.setData(json);

        return  j;
    }


    // 查询已经出库的方法
    @RequestMapping("/toOrderAllYFH")
    @ResponseBody
    public JsonResponseBody OrderAllPage1(HttpServletRequest request, Order order){
        //创建pageBean
        PageBean pageBean=new PageBean();
        //初始化
        pageBean.setRequest(request);
        //查询订单
        List<Map<String,Object>> json= orderService.OrderAllpage1(order,pageBean);
        System.out.println(json);
        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 页码
        j.setTotal(pageBean.getTotal());
        // 数据
        j.setData(json);

        return  j;
    }

    //查询单个订单
    @RequestMapping("/toOrderByid")
    @ResponseBody
    public JsonResponseBody OrderById( Long orderId){
//        System.out.println(orderId);
        Order json= orderService.Orderbyid(orderId);
//        System.out.println(json);
        //返回一个JsonResponseBody
        JsonResponseBody<Order> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);

        return  j;
    }

    @RequestMapping("/updateorderstate")
    @ResponseBody
    public JsonResponseBody updatestate(Order order){
//       System.out.println(orderId);
        int json= orderService.Order_type(order);
        System.out.println(json);
        //返回一个JsonResponseBody
        JsonResponseBody<Order> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        if(order.getOrderStatc()==1){
            j.setMsg("发货成功待出库");
        }else if(order.getOrderStatc()==2){
            j.setMsg("退货申请成功等待审核");
        }

        return  j;
    }

    //订单添加方法
    @RequestMapping("/inserorder")
    @ResponseBody
    public JsonResponseBody insertOrder(@RequestBody  Map<String,Object> map){

                JsonResponseBody<Order> j=new JsonResponseBody<>();
                 //从后台得到总价格
                //总价格
                Object pTotalmoney = (Object) map.get("pTotalmoney");
                //客户
                Object  cid = (Object) map.get("pSupplieruuid");
               //订单编号
                Object  rderId = (Object) map.get("orderId");

                 //创建订单
                 Order order=new Order();
                //订单编号
                 long ddid = Long.valueOf(String.valueOf(rderId));
                 order.setOrderId(ddid);
                 //客户id
                 long khid = Long.valueOf(String.valueOf(cid));
                 order.setOrderCid(khid);
                  //创建人
                  order.setOrderCreatePerson("黄启德");                                //===自己给
                  //运单号
                  order.setOrderYdh("14332233");                                       //===自己给
                  //总价格
                  long zjg = Long.valueOf(String.valueOf(pTotalmoney));
                  order.setOrderMoney(zjg);
                  //订单状态
                   Long ddzt=0l;
                  order.setOrderStatc(ddzt);
                  //添加订单
                Long orderId=orderService.insert(order);
//                System.out.println(orderId);

        //前端数据==》转化为json集合
        ObjectMapper mapper=new ObjectMapper();
        List<OrderListVo> orderListsvo= mapper.convertValue(map.get("purchaseList"),new TypeReference<List<OrderListVo>>(){});
        //循环遍历 订单明细
        for (OrderListVo O : orderListsvo) {
            //为订单明细设置值
            OrderListVo rderList=O;
            //订编号
            rderList.setOrderId(ddid);
            //商品状态
            rderList.setGoodType(0);
            //添加订单明细
            int i=orderListService.insert(rderList);
        }
         j.setMsg("添加成功");
         return j;
    }





}





