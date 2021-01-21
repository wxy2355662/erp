package com.mar.erp.purchase.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.model.ReturnGoods;
import com.mar.erp.purchase.model.ReturnGoodsDetails;
import com.mar.erp.purchase.service.IReturnGoodsDetailsService;
import com.mar.erp.purchase.service.IReturnGoodsService;
import com.mar.erp.purchase.util.PageBean;
import com.mar.erp.purchase.vo.ReturnGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/returnGood")
public class ReturnGoodsController {

    @Autowired
    private IReturnGoodsService returnGoodsService;

    @Autowired
    private IReturnGoodsDetailsService returnGoodsDetailsService;


    /**
     * 查询所有退货订单
     * @param request
     * @param returnGoodsVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectGoodsPager")
    public JsonResponseBody<?> selectGoodsPager(HttpServletRequest request, ReturnGoodsVo returnGoodsVo){
        try {
            PageBean pageBean=new PageBean();
            pageBean.setRequest(request);
            List<ReturnGoodsVo> returnGoodsVos = returnGoodsService.selectGoodsPager(returnGoodsVo, pageBean);
            JsonResponseBody<List<ReturnGoodsVo>> j=new JsonResponseBody<>();
            j.setTotal(pageBean.getTotal());
            j.setData(returnGoodsVos);
            return j;
        } catch (Exception e) {
          throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }

    /**
     * 查询未审核订单
     * @param request
     * @param returnGoodsVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectGoodsAPager")
    public JsonResponseBody<?> selectGoodsAPager(HttpServletRequest request, ReturnGoodsVo returnGoodsVo){
        try {
            PageBean pageBean=new PageBean();
            pageBean.setRequest(request);
            List<ReturnGoodsVo> returnGoodsVos = returnGoodsService.selectGoodsAPager(returnGoodsVo, pageBean);
            JsonResponseBody<List<ReturnGoodsVo>> j=new JsonResponseBody<>();
            j.setTotal(pageBean.getTotal());
            j.setData(returnGoodsVos);
            return j;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }


    /**
     * 修改订单状态
     * @param returnGoods
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateByPrimaryKeySelective")
    public JsonResponseBody<?> updateByPrimaryKeySelective(ReturnGoods returnGoods){
        try {
            int i = returnGoodsService.updateByPrimaryKeySelective(returnGoods);
            JsonResponseBody j=new JsonResponseBody<>();
            j.setMsg("ok");
            j.setStatus(200);
            return j;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }


    /**
     * 查询已审核订单
     * @param request
     * @param returnGoodsVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectGoodsBPager")
    public JsonResponseBody<?> selectGoodsBPager(HttpServletRequest request, ReturnGoodsVo returnGoodsVo){
        try {
            PageBean pageBean=new PageBean();
            pageBean.setRequest(request);
            List<ReturnGoodsVo> returnGoodsVos = returnGoodsService.selectGoodsBPager(returnGoodsVo, pageBean);
            JsonResponseBody<List<ReturnGoodsVo>> j=new JsonResponseBody<>();
            j.setTotal(pageBean.getTotal());
            j.setData(returnGoodsVos);
            return j;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
    }


    /**
     * 添加退货订单和退货订单明细
     * @param returnGoodsVo
     * @return
     */

    @ResponseBody
    @RequestMapping("/insertGoodsanDeiler")
    public JsonResponseBody<?> insertGoodsanDeiler(ReturnGoodsVo returnGoodsVo){
        try {

            System.out.println(returnGoodsVo);
            System.out.println("总金额:"+returnGoodsVo.getGoodsCount());
            System.out.println("商品名称:"+returnGoodsVo.getGoodsName());
            System.out.println("商品编号:"+returnGoodsVo.getGoodsId());
            System.out.println("商品数量:"+returnGoodsVo.getGoodsNum());
            System.out.println("商品单价:"+returnGoodsVo.getGoodsPrice());

            //先判断有没有退货订单根据(这是采购订单编号)订单编号
            System.out.println("采购订单编号:"+returnGoodsVo.getpId());

            //根据采购订单编号查询退货订单
            ReturnGoods returnGoods = returnGoodsService.selectReturnGoods(returnGoodsVo);
            //查询退货订单有没有
            if(returnGoods==null){
                //没有找到退货订单，那就新增一个退货订单
                int i = returnGoodsService.insertSelective(returnGoodsVo);
                System.out.println("退货订单生成成功:"+i);
                System.out.println("退货订单编号:"+returnGoodsVo.getrId());
                //在生成退货订单明细数据
                //退货订单明细
                ReturnGoodsDetails returnGoodsDetails=new ReturnGoodsDetails();
                //退货订单明细编号
                Date date=new Date();
                returnGoodsDetails.setRgId(date.getTime());
                //商品编号
                returnGoodsDetails.setRgGoodId(returnGoodsVo.getGoodsId());
                //商品名称
                returnGoodsDetails.setRgGoodName(returnGoodsVo.getGoodsName());
                //商品单价
                returnGoodsDetails.setRgPrice(returnGoodsVo.getGoodsPrice());
                //商品数量
                returnGoodsDetails.setRgNum(returnGoodsVo.getGoodsNum());
                //总金额
                returnGoodsDetails.setRgMoery(returnGoodsVo.getGoodsCount());
                //退货订单编号
                returnGoodsDetails.setRgOid(returnGoodsVo.getrId());
                //订单明细状态
                returnGoodsDetails.setRgState(1);
                //添加退货订单明细数据
                int tu = returnGoodsDetailsService.insertSelective(returnGoodsDetails);
                System.out.println("退货订单明细数据生成成功："+tu);

            }else {
                System.out.println(2222);
                //如果有退货订单那就直接在退货订单下加订单明细
                ReturnGoodsDetails returnGoodsDetails=new ReturnGoodsDetails();
                //退货订单明细编号
                Date date=new Date();
                returnGoodsDetails.setRgId(date.getTime());
                //商品编号
                returnGoodsDetails.setRgGoodId(returnGoodsVo.getGoodsId());
                //商品名称
                returnGoodsDetails.setRgGoodName(returnGoodsVo.getGoodsName());
                //商品单价
                returnGoodsDetails.setRgPrice(returnGoodsVo.getGoodsPrice());
                //商品数量
                returnGoodsDetails.setRgNum(returnGoodsVo.getGoodsNum());
                //总金额
                returnGoodsDetails.setRgMoery(returnGoodsVo.getGoodsCount());
                //退货订单编号
                returnGoodsDetails.setRgOid(returnGoods.getrId());
                //订单明细状态
                returnGoodsDetails.setRgState(1);
                //添加退货订单明细数据
                int tu = returnGoodsDetailsService.insertSelective(returnGoodsDetails);
                System.out.println("退货订单明细数据生成成功："+tu);

                //修改退货金额
                ReturnGoods r=new ReturnGoods();
                //订单编号
                r.setrId(returnGoods.getrId());
                //获取前端退货的金额+数据库获取到的金额
                r.setrTotalmoney(returnGoodsVo.getGoodsCount()+returnGoods.getrTotalmoney());
                //修改订单里的金额
                int i = returnGoodsService.updateByPrimaryKeySelective(r);
                System.out.println("订单总金额修改成功:"+i);

            }

            JsonResponseBody j=new JsonResponseBody<>();
            j.setMsg("ok");
            j.setStatus(200);
            return j;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_601);
        }
    }


    /**
     * 修改订单状态为审核未通过
     * @param returnGoodsVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSelective")
    public JsonResponseBody<?> updateSelective(ReturnGoodsVo returnGoodsVo){
        try {
            int i = returnGoodsService.updateByPrimaryKeySelective(returnGoodsVo);
            JsonResponseBody<List<ReturnGoodsVo>> j=new JsonResponseBody<>();
            j.setStatus(200);
            j.setMsg("ok");
            return j;
        } catch (Exception e) {
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
    }















}
