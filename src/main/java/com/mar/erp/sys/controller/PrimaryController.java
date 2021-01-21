package com.mar.erp.sys.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.sys.service.IPermissionService;
import com.mar.erp.sys.vo.PermissionVo;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PrimaryController {

    @Autowired
    private IPermissionService permissionService;
    @Resource(name="mailSender")
    JavaMailSenderImpl mailSender;

    @RequestMapping("/queryPermission")
    public JsonResponseBody<List<PermissionVo>> queryPermission(){
        List<PermissionVo> permissionVos = permissionService.queryPrimaryByParent();

        if(permissionVos.size()<1){
            throw new BusinessException(ResponseStatus.STATUS_604);
        }

        return new JsonResponseBody<>(permissionVos);
    }




}
