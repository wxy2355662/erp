package com.mar.erp.basics.controller;

import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.basics.model.Supplier;
import com.mar.erp.basics.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;


    //查询所有供应商
    @RequestMapping("/selectSupplier")
    @ResponseBody
    public JsonResponseBody selectSupplier(){
        List<Supplier> suppliers = supplierService.selectSupplier();
        JsonResponseBody<List<Supplier>> j=new JsonResponseBody();
        j.setData(suppliers);
        j.setStatus(200);
        return j;
    }




}
