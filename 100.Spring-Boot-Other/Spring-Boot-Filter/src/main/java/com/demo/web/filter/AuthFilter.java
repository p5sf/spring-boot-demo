package com.demo.web.filter;

import com.demo.web.bean.AuthBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Yan
 * 方式一：通过@WebFilter注解方式注册
 * 通过实际测试@order没有效果，在不考虑web.xml的场景下，只能通过在注册Bean的时候指定优先级
 */
@Slf4j
@Order(2)
@WebFilter
public class AuthFilter implements Filter, Ordered {

    @Autowired
    private AuthBean authBean;

    public AuthFilter() {
        System.out.println("init autFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("in auth filter! {}", authBean);
        HttpServletRequest req = (HttpServletRequest) request;
        String auth = req.getHeader("tx-demo");
        if ("auth".equals(auth)) {
            // 认证的请求允许访问，请求头中没有这个时，不执行下面的的方法，则表示请求被过滤了
            // chain.doFilter(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 注册Bean 指定优先级
     * @return
     */
    @Override
    public int getOrder() {
        return 2;
    }
}
