package com.mar.erp.sys.controller;

import com.mar.erp.sys.service.IPermissionService;
import com.mar.erp.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PrimaryController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/queryPermission")
    @ResponseBody
    public List<PermissionVo> queryPermission(){
        return  permissionService.queryPrimaryByParent();
    }




}
