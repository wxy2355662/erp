package com.mar.erp.sell.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.sell.Vo.OrderOutListVo;
import com.mar.erp.sell.model.OrderOut;
import com.mar.erp.sell.model.OrderOutDetails;
import com.mar.erp.sell.service.OrderOutDetailsService;
import com.mar.erp.sell.service.OrderOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderout")
public class OrderOutController {
    //注入sevice
    @Autowired
    private OrderOutService orderOutService;
    @Autowired
    OrderOutDetailsService orderOutDetailsService;


    //查询所有退货订单
    @RequestMapping("/toOrderOutAll")
    @ResponseBody
    public JsonResponseBody OrderOutAllPage(HttpServletRequest request, OrderOut orderOut){

        //创建pageBean
        PageBean pageBean=new PageBean();
        //初始化
        pageBean.setRequest(request);
        //查询订单
        List<Map<String,Object>> json= orderOutService.OrderOutAllpage(orderOut);
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

    //查询待审核的订单state=1
    @RequestMapping("/toOrderState")
    @ResponseBody
    public JsonResponseBody OrderOutState(HttpServletRequest request, OrderOut orderOut){

        //创建pageBean
        PageBean pageBean=new PageBean();
        //初始化
        pageBean.setRequest(request);
        //查询订单
        List<Map<String,Object>> json= orderOutService.OrderOutByState(orderOut);
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


    //修改退货订单状态
    @RequestMapping("/toUpdateState")
    @ResponseBody
    public JsonResponseBody OrderUpdateState(OrderOut orderOut){
//        System.out.println(orderOut.getoState());
//        System.out.println(orderOut.getoId());
        //查询订单
        int  i= orderOutService.updateState(orderOut);
        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
       if(i>0 && orderOut.getoState()==1){          //未通过
           j.setMsg("已为您审核不通过");
       }else if(i>0 && orderOut.getoState()==2){   //通过
           j.setMsg("审核通过成功等待退货");
       }else if(orderOut.getoState()==0){
           j.setMsg("已为您重新提交审核");
       }

        return  j;
    }

    //查询待审核的订单state=1
    @RequestMapping("/toOrderStateOne")
    @ResponseBody
    public JsonResponseBody OrderOutStateoOne(HttpServletRequest request, OrderOut orderOut){

        //创建pageBean
        PageBean pageBean=new PageBean();
        //初始化
        pageBean.setRequest(request);
        //查询订单
        List<Map<String,Object>> json= orderOutService.OrderOutBySataeOne(orderOut);
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

    //添加退货订单以及退货订单明细
    @RequestMapping("/InsertOutAndList")
    @ResponseBody
    public JsonResponseBody OrderOutinsert(@RequestBody Map<String,Object> map){

        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //接收前端数据
        //订单号
        Object orderId = (Object) map.get("orderId");
        //总金额
        Object orderMoney = (Object) map.get("orderMoney");
        //客户id
        Object  cid = (Object) map.get("cid");
        //运单号
        Object  orderYdh = (Object) map.get("orderYdh");
        //退货员
        Object  orderCreatePerson = (Object) map.get("orderCreatePerson");


       //创建一个退货订单
        OrderOut orderOut =new OrderOut();
        long orderId1 = Long.valueOf(String.valueOf(orderId));
        long orderMoney1 = Long.valueOf(String.valueOf(orderMoney));
        long cid1 = Long.valueOf(String.valueOf(cid));
        String orderYdh1 = String.valueOf(orderYdh);
        String oCreatePerson = String.valueOf(orderCreatePerson);

        //给退货订单设置值
        orderOut.setOrderId(orderId1);
        orderOut.setoMoney(orderMoney1);
        orderOut.setcId(cid1);
        orderOut.setpWaybill(orderYdh1);
        orderOut.setoCreatePerson(oCreatePerson);

        //添加退货订单
        int i=orderOutService.insert(orderOut);
        

        //前端数据==》转化为json集合
        ObjectMapper mapper=new ObjectMapper();
        List<OrderOutListVo> orderOutDetails= mapper.convertValue(map.get("purchaseListt"),new TypeReference<List<OrderOutListVo>>(){});
       //输出
//     orderOutDetails.forEach(System.out::println);

        //把前端传过来的值用Vo类c传递到退货订单明细里面
       List<OrderOutDetails> list =new ArrayList<>();
        for (OrderOutListVo o : orderOutDetails) {
         //给退货订单明细
        OrderOutDetails orderlist=new OrderOutDetails();
        orderlist.setOroGoodId(o.getGoodId());
        orderlist.setOroGoodName(o.getGoodName());
        orderlist.setOroGoodPrice(o.getGoodPrice());
        orderlist.setOroGoodCount(o.getGoodCount());
        orderlist.setOroState(0);
        orderlist.setOroMoney(o.getGoodMoney());
        list.add(orderlist);
        }
        //循环添加订单明细
        for (OrderOutDetails c : list) {
            OrderOutDetails outlist=c;
            outlist.setOroOrderId(orderId1);
            outlist.setoId(orderOut.getoId());
            int ic= orderOutDetailsService.insert(outlist);
//            System.out.println(ic);
        }
        //返回信息
        if(i>0){
            j.setMsg("退货订单添加成功等待审核");
        }

        return  j;
    }



}
