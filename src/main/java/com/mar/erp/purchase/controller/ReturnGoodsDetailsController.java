package com.mar.erp.purchase.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.purchase.model.ReturnGoodsDetails;
import com.mar.erp.purchase.service.IReturnGoodsDetailsService;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.ReturnGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ReturnGoodsDetailS")
public class ReturnGoodsDetailsController {


    @Autowired
    private IReturnGoodsDetailsService returnGoodsDetailsService;

    /**
     * 根据退货订单编号查询退货订单明细
     * @param returnGoodsDetails
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectDetailsDoods")
    public JsonResponseBody<?> selectDetailsDoods(ReturnGoodsDetails returnGoodsDetails){
        try {
            JsonResponseBody<List<ReturnGoodsDetails>> j= new JsonResponseBody<>();
            List<ReturnGoodsDetails> ReturnGoodsDetails = returnGoodsDetailsService.selectDetailsDoods(returnGoodsDetails);
            j = new JsonResponseBody<>();
            j.setData(ReturnGoodsDetails);
            return j;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }



}
