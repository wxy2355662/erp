package com.mar.erp.base.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.base.util.ResponseStatus;
import com.sun.webkit.perf.WCFontPerfLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect1 {

    @Around(value="execution(* *..*Service.*Pagers(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable{

        Object[] params = args.getArgs();
        //分页对象
        PageBean pageBean=null;
        for (Object param : params) {
            if(param instanceof PageBean){
                pageBean= (PageBean) param;
                break;
            }
        }
        //设置分页参数
        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        //执行方法，得到返回结果
        Object result = args.proceed(params);
        JsonResponseBody data= (JsonResponseBody) result;
        if(null!=pageBean&&pageBean.isPagination()){
            if(null==data.getData())
                return new JsonResponseBody<>(ResponseStatus.STATUS_602);
            List lst= (List) data.getData();
            PageInfo pi=new PageInfo(lst);
            pageBean.setTotal(pi.getTotal()+"");
            return new JsonResponseBody<>(lst,pageBean.getTotal());
        }
        return new JsonResponseBody<>(data.getData());
    }

}
