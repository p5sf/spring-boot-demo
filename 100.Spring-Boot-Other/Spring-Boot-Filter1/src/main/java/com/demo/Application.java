package com.demo;


import com.demo.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月16日 22:23
 */

@ServletComponentScan
@SpringBootApplication
public class Application {

    public Application(ApplicationContext applicationContext) {
        try {
            Object obj = applicationContext.getBean("requestFilter");
            Object obj2 = applicationContext.getBean(RequestFilter.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
