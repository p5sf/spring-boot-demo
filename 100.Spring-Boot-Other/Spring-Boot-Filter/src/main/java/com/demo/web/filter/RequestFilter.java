package com.demo.web.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author Yan
 */
@Slf4j
@Order(1)
@WebFilter
public class RequestFilter implements Filter, Ordered {

    public RequestFilter() {
        System.out.println("init reqFilter");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("url={}, params={}", req.getRequestURI(), JSON.toJSONString(req.getParameterMap()));
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
