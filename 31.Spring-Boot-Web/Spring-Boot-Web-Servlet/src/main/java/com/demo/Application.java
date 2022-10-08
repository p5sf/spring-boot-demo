package com.demo;

import com.demo.servlet.RegisterBeanServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author YanZhao
 * @description 不建议使用方式三和四
 * https://spring.hhui.top/spring-blog/2019/11/22/191122-SpringBoot%E7%B3%BB%E5%88%97%E6%95%99%E7%A8%8Bweb%E7%AF%87Servlet-%E6%B3%A8%E5%86%8C%E7%9A%84%E5%9B%9B%E7%A7%8D%E5%A7%BF%E5%8A%BF/
 * @date 2022年09月16日 23:10
 */

@SpringBootApplication
@ServletComponentScan
public class Application {
        public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
