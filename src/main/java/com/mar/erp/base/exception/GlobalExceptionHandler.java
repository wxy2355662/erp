package com.mar.erp.base.exception;

import com.mar.erp.base.util.ResponseStatus;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * 1)@ExceptionHandler
 * 2)实现HandlerExceptionResolver
 *  @Component 注入spring上下文
 * 3)@ControllerAdvice+@ExceptionHandler
 */

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param target 目标对象
     * @param e      异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object target, Exception e) {
        ModelAndView mv=new ModelAndView();

            //如果是ajax请求，都返回json字符串
            if(e instanceof BusinessException){
                //后台报错
                e.printStackTrace();
                //自定义异常
                mv.addObject("msg",((BusinessException) e).getMsg());
                mv.addObject("status",((BusinessException) e).getCode());
                mv.addObject("success","false");
            }
            else if(e instanceof UnauthorizedException){
                e.printStackTrace();
                //自定义异常
                mv.addObject("msg","无操作权限！");
                mv.addObject("status","607");
                mv.addObject("success","false");
            }
            else if(e instanceof UnauthenticatedException){
                e.printStackTrace();
                //自定义异常
                mv.addObject("msg","登录身份过期，请重新登录！");
                mv.addObject("status","605");
                mv.addObject("success","false");
            }
            else
                {
                //控制台报错
                e.printStackTrace();
                //未知异常
                mv.addObject("msg","系统崩溃了,请联系管理员！");
                mv.addObject("status", "999");
                mv.addObject("success","false");
            }
            mv.setView(new MappingJackson2JsonView());

        return mv;
    }


    /**
     * 判断请求是否为Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        //如果requestType能拿到值，并且值为 XMLHttpRequest ,表示客户端的请求为异步请求，那自然是ajax请求了，反之如果为null,则是普通的请求
        if(requestType == null){
            return false;
        }
        return true;

    }

}
