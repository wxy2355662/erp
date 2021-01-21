package com.mar.erp.base.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mar.erp.base.util.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PageAspect {

    /**
     *  1、* :返回值不限
     *  2、*..:包名不限
     *  3、*Service：以Service结尾的类或接口
     *  4、*Pager：以Pager结尾的方法名
     *  5、(..):参数类型个数不限
     *
     */

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取目标方法的执行参数
        Object[] params = joinPoint.getArgs();
        //定义PageBean对象
        PageBean pageBean = null;
        //循环执行参数
        for (Object param : params) {
            //判断执行参数是否是PageBean类型
            if(param instanceof PageBean){
                pageBean=(PageBean)param;
                break;
            }
        }

        //判断PageBean是否为空
        if(null!=pageBean && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        //执行目标方法

        Object returnValue = joinPoint.proceed(params);

        if(null!=pageBean && pageBean.isPagination()){
            List list= (List) returnValue;
            PageInfo pageInfo = new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }

        return returnValue;


    }


}
