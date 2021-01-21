package com.mar.erp.repertory.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.basics.service.IStoreService;
import com.mar.erp.purchase.model.PurchaseDetails;
import com.mar.erp.purchase.model.ReturnGoodsDetails;
import com.mar.erp.purchase.service.IPurchaseDetailsService;
import com.mar.erp.purchase.service.IReturnGoodsDetailsService;
import com.mar.erp.repertory.model.Stopeoper;
import com.mar.erp.repertory.model.Storedetail;
import com.mar.erp.repertory.service.IStopeoperService;
import com.mar.erp.repertory.service.IStoredetailService;
import com.mar.erp.repertory.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/storedetail")
public class StoredetailController {

    @Autowired
    private IStoredetailService storedetailService;


    @Autowired
    private IPurchaseDetailsService purchaseDetailsService;


    @Autowired
    private IStopeoperService stopeoperService;


    @Autowired
    private IReturnGoodsDetailsService returnGoodsDetailsService;

    /**
     * 查询库存表中有没有重复的数据
     * @param storedetailVo
     * @return
     */
    @RequestMapping("/selectStoredetail")
    @ResponseBody
    public JsonResponseBody<?> selectStoredetail(StoredetailVo storedetailVo){
            Storedetail storedetail = storedetailService.selectStoredetail(storedetailVo);
            //判断库存表中有没有查询到数据
//            System.out.println(storedetailVo.getSrId());
//            System.out.println(storedetailVo.getSdNum());
//            System.out.println("订单明细编号:"+storedetailVo.getPiId());
//            System.out.println("员工编号:"+storedetailVo.geteId());

            if(storedetail==null){
                System.out.println("没有查询到库存表中的数据");
                //没有就新增库存数据
                int i = storedetailService.insertSelective(storedetailVo);
                System.out.println(i);
                //修改订单明细状态
                PurchaseDetails p=new PurchaseDetails();
                p.setPiId(storedetailVo.getPiId());
                p.setPiState(2l);
                int pueDe = purchaseDetailsService.updateByPrimaryKeySelective(p);
                System.out.println("订单明细状态修改成功:"+pueDe);
                //添加仓库操作记录 数据
                Stopeoper stopeoper=new Stopeoper();
                //赋值员工编号
                stopeoper.seteId(storedetailVo.geteId());
                stopeoper.setSrId(storedetailVo.getSrId());
                stopeoper.setgId(storedetailVo.getgId());
                stopeoper.setStNum(storedetailVo.getSdNum());
                stopeoper.setStType("入库");
                int stope = stopeoperService.insertSelective(stopeoper);
                System.out.println("仓库操作记录成功:"+stope);
            }else{
                Storedetail s=new Storedetail();
                //设置库存id
                s.setSdId(storedetail.getSdId());
                //拿到数据库里的数量加上前端传来的数量
                s.setSdNum(storedetail.getSdNum()+storedetailVo.getSdNum());
                //有就修改数量
                int i = storedetailService.updateByPrimaryKeySelective(s);
                System.out.println("修改成功:"+i);
                //修改订单明细状态
                PurchaseDetails p=new PurchaseDetails();
                p.setPiId(storedetailVo.getPiId());
                System.out.println(p.getPiId());
                p.setPiState(2l);
                int pueDe = purchaseDetailsService.updateByPrimaryKeySelective(p);
                System.out.println("订单明细状态修改成功:"+pueDe);
                //添加仓库操作记录 数据
                Stopeoper stopeoper=new Stopeoper();
                //赋值员工编号
                stopeoper.seteId(storedetailVo.geteId());
                stopeoper.setSrId(storedetailVo.getSrId());
                stopeoper.setgId(storedetailVo.getgId());
                stopeoper.setStNum(storedetailVo.getSdNum());
                stopeoper.setStType("入库");
                int stope = stopeoperService.insertSelective(stopeoper);
                System.out.println("仓库操作记录成功:"+stope);
            }

            JsonResponseBody jsonResponseBody=new JsonResponseBody();
            jsonResponseBody.setStatus(200);
            jsonResponseBody.setMsg("ok");
            return jsonResponseBody;
    }





    @RequestMapping("/selectStoreDeitlerCk")
    @ResponseBody
    public JsonResponseBody<?> selectStoreDeitlerCk(StoredetailVo storedetailVo){
        //根据仓库编号和商品编号查询单个
        Storedetail storedetail = storedetailService.selectStoredetail(storedetailVo);
        System.out.println("商品数量:"+storedetailVo.getSdNum());
        System.out.println("商品编号:"+storedetailVo.getgId());
        System.out.println("仓库编号:"+storedetailVo.getSrId());
        System.out.println("订单明细编号:"+storedetailVo.getRgId());
        System.out.println("仓库管理员编号:"+storedetailVo.geteId());

        if(storedetail!=null){
            Storedetail sto=new Storedetail();
            sto.setSdId(storedetail.getSdId());
            sto.setSdNum(storedetail.getSdNum()-storedetailVo.getSdNum());
            //修改库存表中的商品数量
            int i = storedetailService.updateByPrimaryKeySelective(sto);
            System.out.println("数量修改成功:"+i);
            //修改订单明细状态
            ReturnGoodsDetails returnGoodsDetails=new ReturnGoodsDetails();
            returnGoodsDetails.setRgId(storedetailVo.getRgId());
            returnGoodsDetails.setRgState(2);
            returnGoodsDetails.setWarehouseId(storedetailVo.getSrId());
            int de = returnGoodsDetailsService.updateByPrimaryKeySelective(returnGoodsDetails);
            System.out.println("订单明细状态修改成功:"+de);
            //添加仓库操作记录数据
            Stopeoper stopeoper=new Stopeoper();
            //赋值员工编号
            stopeoper.seteId(storedetailVo.geteId());
            //赋值仓库编号
            stopeoper.setSrId(storedetailVo.getSrId());
            //赋值商品编号
            stopeoper.setgId(storedetailVo.getgId());
            //赋值出库商品数量
            stopeoper.setStNum(storedetailVo.getSdNum());
            stopeoper.setStType("出库");
            int stope = stopeoperService.insertSelective(stopeoper);
            System.out.println("添加仓库操作记录成功:"+stope);
            JsonResponseBody jsonResponseBody=new JsonResponseBody();
            jsonResponseBody.setMsg("ok");
            jsonResponseBody.setStatus(200);
            return jsonResponseBody;
        }else{
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
    }




    //出库的方法
    @RequestMapping("/tochuku")
    @ResponseBody
    public JsonResponseBody Storedetailck(Storedetail storedetail){
        JsonResponseBody<Storedetail> j =new JsonResponseBody<>();
        //得到出库的库存数量
        Storedetail sdNum= storedetailService.selectbysrg(storedetail);
        if(null!=sdNum){
            //减少库存数量
            storedetail.setSdNum(sdNum.getSdNum());



        if(storedetail.getSdNum()>=storedetail.getNum()){

            storedetail.setSdNum(sdNum.getSdNum()-storedetail.getNum());
            //返回大于1（）
            int i=storedetailService.updatebysrg(storedetail);
            //为JsonResponseBody 设置数据
            // 数据
            if(i>0){
                j.setMsg("出库成功");
            }

        }else{
            j.setMsg("库存数量不足");
        }

        }else{
            j.setMsg("库存数量不足");
        }

        return  j;

    }

    //出库的方法
    @RequestMapping("/toruku")
    @ResponseBody
    public JsonResponseBody Storedetailckrk(Storedetail storedetail){
        JsonResponseBody<Storedetail> j =new JsonResponseBody<>();
        //得到出库的库存数量
        Storedetail sdNum= storedetailService.selectbysrg(storedetail);
        //减少库存数量
        System.out.println(storedetail.getSrId());
        System.out.println(storedetail.getgId());


        if(null!=sdNum){
            storedetail.setSdNum(sdNum.getSdNum()+storedetail.getNum());
            //返回大于1（）
            int i=storedetailService.updatebysrg(storedetail);
            //为JsonResponseBody 设置数据
            // 数据
            if(i>0){
                j.setMsg("入库成功");
            }
        }else {
            j.setMsg("该商品不在这个仓库");
        }

        return  j;

    }










}
