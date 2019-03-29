package com.hht.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 登录拦截器
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 如果是login则放行, 其他拦截
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String uri = request.getRequestURI();
        return !uri.endsWith("login") && !uri.endsWith("Login");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 获取请求对象
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (token == null || "".equals(token)) {
            // 需要先登录
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().setContentType("text/html;charset=UTF-8");
                requestContext.getResponse().getWriter().write("请先进行登录!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
