package com.mar.erp.base.exception;

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
//        //业务异常、系统异常
//        if(e instanceof UnauthorizedException){
//            System.out.println("无权限异常");
//            //mv.setViewName("unauthorized");
//            mv.addObject("msg","无权限异常");
//            mv.addObject("success","true");
//            mv.setView(new MappingJackson2JsonView());
//        }else if(e instanceof  BusinessException){
//            mv.addObject("msg",e.getMessage());
//            mv.addObject("success","true");
//            mv.setView(new MappingJackson2JsonView());
//        }
        return mv;
    }
}
