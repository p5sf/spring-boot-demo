package com.demo;

import com.demo.interceptor.SecurityInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月17日 9:25
 */

@SpringBootApplication
public class Application implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor()).addPathPatterns("/**");
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
