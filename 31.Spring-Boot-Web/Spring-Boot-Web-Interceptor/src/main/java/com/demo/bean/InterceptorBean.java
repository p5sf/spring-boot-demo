package com.demo.bean;

import com.demo.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YanZhao
 * @description
 * 方式二：将securityInterceptor声明为Bean对象
 * @date 2022年09月17日 10:12
 */


@Configuration
public class InterceptorBean implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( securityInterceptor()).addPathPatterns("/**");
    }
}
