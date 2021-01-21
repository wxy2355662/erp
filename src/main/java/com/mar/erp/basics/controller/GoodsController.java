package com.mar.erp.basics.controller;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.basics.model.Goods;
import com.mar.erp.basics.service.IGoodsService;
import com.mar.erp.basics.service.impl.IGoodsServiceImpl;
import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/selectGoods")
    @ResponseBody
    public JsonResponseBody selectGoods(Goods goods){
        List<Goods> goods1 = goodsService.selectGoods(goods);
        JsonResponseBody<List<Goods>> j=new JsonResponseBody<>();
        j.setData(goods1);
        return j;
    }


    @RequestMapping("/selectDgGoods")
    @ResponseBody
    public JsonResponseBody selectDgGoods(Goods goods){
        Goods goods1 = goodsService.selectDgGoods(goods);
//        System.out.println(goods1.getgName());
        JsonResponseBody<Goods> j=new JsonResponseBody<>();
        j.setData(goods1);
        return j;
    }





 //HUANG QI DE
    //查询所有商品信息
    @RequestMapping("/goodsAll")
    @ResponseBody
    public JsonResponseBody StoreALL(){
        //查询订单
        List<Map<String,Object>> json= goodsService.Goodsall();

        //返回一个JsonResponseBody
        JsonResponseBody< List<Map<String,Object>>> j=new JsonResponseBody<>();
        //为JsonResponseBody 设置数据
        // 数据
        j.setData(json);

        return  j;
    }

    //查询单个商品信息
    @RequestMapping("/goodsbyid")
    @ResponseBody
    public JsonResponseBody Storebyid(Goods goods){
        //查询订单
        Goods json= goodsService.GoodsBYID(goods);

        //返回一个JsonResponseBody
        JsonResponseBody<Goods> j=new JsonResponseBody<>();

        //为JsonResponseBody 设置数据
        j.setData(json);

        return  j;
    }






}
