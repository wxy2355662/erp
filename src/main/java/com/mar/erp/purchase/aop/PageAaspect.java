package com.mar.erp.purchase.aop;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mar.erp.purchase.util.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAaspect {

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取目标方法的执行参数
        Object[] params =joinPoint.getArgs();
        //定义PageBean对象
        PageBean pageBean=null;
        //循环执行参数
        for (Object param : params) {
            if(param instanceof PageBean){
                pageBean =(PageBean) param;
                break;
            }
        }

        //判断PageBean是否为空
        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        //执行目标方法
        Object returnValue = joinPoint.proceed(params);
        if(null!=pageBean&&pageBean.isPagination()){
            List list=(List) returnValue;
            PageInfo pageInfo=new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return  returnValue;
    }













}
