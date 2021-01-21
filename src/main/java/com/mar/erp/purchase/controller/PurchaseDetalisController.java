package com.mar.erp.purchase.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.model.PurchaseDetails;
import com.mar.erp.purchase.model.ReturnGoodsDetails;
import com.mar.erp.purchase.service.IPurchaseDetailsService;
import com.mar.erp.purchase.service.IPurchaseService;
import com.mar.erp.purchase.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/purchaseDetalis")
public class PurchaseDetalisController {


    @Autowired
    private IPurchaseDetailsService purchaseDetailsService;


    @Autowired
    private IPurchaseService purchaseService;

    /**
     * 根据订单id查询订单明细
     * @return
     */
    @RequestMapping("/queryPuerDetails")
    @ResponseBody
    public JsonResponseBody queryPuerDetails(PurchaseDetails purchaseDetails){
        try {
            return purchaseDetailsService.queryPuerDetails(purchaseDetails);
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }



    @RequestMapping("/insertPurchaseDetail")
    @ResponseBody
    public JsonResponseBody insertPurchaseDetail(@RequestBody Map<String,Object> mlist){

        try {
            //退货订单明细集合
            List<ReturnGoodsDetails> list=(List<ReturnGoodsDetails>) mlist.get("PurchaseListAll");
            System.out.println(list);
            ObjectMapper mapper = new ObjectMapper();
            List<ReturnGoodsDetails> list1 = mapper.convertValue(list, new TypeReference<List<ReturnGoodsDetails>>() { });

            //订单编号
            Long pId=(Long) mlist.get("pId");
            System.out.println("订单编号:"+pId);
            //退款总金额
            BigDecimal pTotalmoney = BigDecimal.valueOf( Double.valueOf( mlist.get("sum").toString()));
            System.out.println("退货总金额:"+pTotalmoney);

            //采购订单明细
            List<PurchaseDetails> pus=new ArrayList<>();
            for (ReturnGoodsDetails returnGoodsDetails : list1) {
                PurchaseDetails tu=new PurchaseDetails();
                tu.setPiId(returnGoodsDetails.getRgId());
                tu.setPiGoodId(returnGoodsDetails.getRgGoodId());
                tu.setPiGoodName(returnGoodsDetails.getRgGoodName());
                tu.setPiPrice(returnGoodsDetails.getRgPrice());
                tu.setPiNum(returnGoodsDetails.getRgNum());
                tu.setPiMoery(returnGoodsDetails.getRgMoery());
                tu.setPiState(3l);
                pus.add(tu);
            }

            for (PurchaseDetails purchaseDetails : pus) {
                System.out.println("订单明细状态:"+purchaseDetails.getPiState());
            }

            //退货审核成功添加订单明细
            int i = purchaseDetailsService.insertTousdsDetails(pus, pId);
            System.out.println("订单明细添加成功:"+i);
            //修改订单金额
            //1.根据订单编号查询单个得到数据库的总金额
            Purchase purchase = purchaseService.selectByPrimaryKey(pId);
            //得到数据库的总金额
            Long total= purchase.getpTotalmoney();
            Purchase p=new Purchase();
            p.setpId(pId);
            p.setpTotalmoney(total-pTotalmoney.longValue());
            int ptuoo = purchaseService.updateByPrimaryKeySelective(p);
            System.out.println("总金额修改成功:"+ptuoo);
            //定义返回到前端的信息
            JsonResponseBody j=new JsonResponseBody();
            j.setStatus(200);
            j.setMsg("ok");
            return j;
        } catch (IllegalArgumentException e) {
            throw  new BusinessException(ResponseStatus.STATUS_608);
        }

    }












}
