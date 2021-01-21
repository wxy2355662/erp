package com.mar.erp.base.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.ResponseStatus;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;


@Component
public class ShiroUserFilter extends UserFilter {

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        //        super.redirectToLogin(request, response);
        response.setContentType("application/json; charset=utf-8");
        //返回json
        ObjectMapper objectMapper=new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(new JsonResponseBody<>(ResponseStatus.STATUS_607)));
    }
}
