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






}
