package com.demo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author YanZhao
 * @description
 * 直接将Filter 当成普通对象的Bean对象，也就是直接在Filter类上添加注解@Component，然后将实现Filter接口的Bean当做过滤器来注册，
 * 优点 优先级可以通过@Order注解来指定
 * @date 2022年09月16日 22:31
 */


@Order(10)
@Component
public class OrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("order filter!");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
