package com.demo.web;

import com.demo.web.filter.OrderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

/**
 * @author Yan
 *https://spring.hhui.top/spring-blog/2019/10/16/191016-SpringBoot%E7%B3%BB%E5%88%97%E6%95%99%E7%A8%8Bweb%E7%AF%87%E4%B9%8B%E8%BF%87%E6%BB%A4%E5%99%A8Filter%E4%BD%BF%E7%94%A8%E6%8C%87%E5%8D%97/
 * 方式二：通过FilterRegistrationBean方式注册Filter
 * 执行顺序 OrderFilter -> ReqFilter -> AuthFilter
 * 注册生效：
 * @ServletComponentScan自动扫描带有@WebFilter注解的Filter
 *
 */
@ServletComponentScan
@SpringBootApplication
public class Application {

    @Bean
    public FilterRegistrationBean<OrderFilter> orderFilter() {
        FilterRegistrationBean<OrderFilter> filter = new FilterRegistrationBean<>();
        filter.setName("orderFilter");
        filter.setFilter(new OrderFilter());
        filter.setOrder(-1);
        return filter;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
