package com.mar.erp.purchase.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.model.PurchaseDetails;
import com.mar.erp.purchase.service.IPurchaseDetailsService;
import com.mar.erp.purchase.service.IPurchaseService;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private IPurchaseDetailsService purchaseDetailsService;


    /**
     * 添加订单和订单明细
     * @param mlist
     * @return
     */
    @RequestMapping("/insertPurchase")
    @ResponseBody
    public JsonResponseBody<?> insertPurchase(@RequestBody Map<String,Object> mlist){

        try {
            //订单明细集合
            List<PurchaseDetails> list=(List<PurchaseDetails>) mlist.get("purchaseList");
            System.out.println(list);
            //供应商
            String pSupplieruuid=(String) mlist.get("pSupplieruuid");
            //订单总金额
            BigDecimal pTotalmoney = BigDecimal.valueOf( Double.valueOf( mlist.get("pTotalmoney").toString()));

            Purchase purchase=new Purchase();
            //订单主键
            Date date=new Date();
            purchase.setpId(date.getTime());
            //默认订单状态为1
            purchase.setpState(1);
            //创建人 死的要从前端传
            purchase.setpCrecker("下单员");
            purchase.setPurchaseList(list);
            purchase.setpTotalmoney(pTotalmoney.longValue());
            purchase.setpSupplieruuid(pSupplieruuid);


            return purchaseService.insertSelective(purchase);
        } catch (Exception e) {
           throw new BusinessException(ResponseStatus.STATUS_601);
        }

    }


    /**
     * 查询所有订单
     * @param request
     * @param purchaseVo
     * @return
     */
    @RequestMapping("/queryPurchasePager")
    @ResponseBody
    public JsonResponseBody queryPurchasePager(HttpServletRequest request, PurchaseVo purchaseVo){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Purchase> purchases = purchaseService.queryPurchasePager(purchaseVo, pageBean);
        JsonResponseBody<List<Purchase>> j=new JsonResponseBody<>();
        j.setTotal(pageBean.getTotal());
        j.setData(purchases);
        return j;
    }


    /**
     * 查询未审核的订单
     * @param request
     * @param purchase
     * @return
     */
    @RequestMapping("/queryPurchaseAPager")
    @ResponseBody
    public JsonResponseBody<?> queryPurchaseAPager(HttpServletRequest request, Purchase purchase){
        try {
            PageBean pageBean=new PageBean();
            pageBean.setRequest(request);
            List<Purchase> purchases = purchaseService.queryPurchaseAPager(purchase, pageBean);
            JsonResponseBody<List<Purchase>> listJsonResponseBody=new JsonResponseBody<>();
            listJsonResponseBody.setData(purchases);
            listJsonResponseBody.setTotal(pageBean.getTotal());
            return listJsonResponseBody;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }

    /**
     * 查询未审核的订单
     * @param request
     * @param purchaseVo
     * @return
     */
    @RequestMapping("/queryPurchasePager2")
    @ResponseBody
    public JsonResponseBody<?> queryPurchasePager2(HttpServletRequest request, PurchaseVo purchaseVo){
        try {
            PageBean pageBean=new PageBean();
            pageBean.setRequest(request);
            return purchaseService.queryPurchasePager2(purchaseVo, pageBean);
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }


    /**
     * 查询已确认的订单
     * @param request
     * @param purchaseVo
     * @return
     */
    @RequestMapping("/queryPurchaseCPager")
    @ResponseBody
    public JsonResponseBody<?> queryPurchaseCPager(HttpServletRequest request, PurchaseVo purchaseVo){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Purchase> purchases = purchaseService.queryPurchaseCPager(purchaseVo, pageBean);
        JsonResponseBody<List<Purchase>> j=new JsonResponseBody<>();
        j.setTotal(pageBean.getTotal());
        j.setData(purchases);
        return j;
    }



    /**
     * 修改订单状态
     * @param purchase
     * @return
     */
    @RequestMapping("/updateByPurchase")
    @ResponseBody
    public JsonResponseBody updateByPurchase(Purchase purchase){
        try {
            return purchaseService.updateByPurchase(purchase);
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
    }




















































}
