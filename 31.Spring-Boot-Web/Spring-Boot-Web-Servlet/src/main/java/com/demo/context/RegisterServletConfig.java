package com.demo.context;

import com.demo.servlet.RegisterBeanServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YanZhao
 * @description 方式二
 * 定义一个ServletRegistrationBean 持有RegisterBeanServlet实例
 * @date 2022年09月17日 0:33
 */

@Configuration
public class RegisterServletConfig {

    @Bean
    public ServletRegistrationBean servletBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.addUrlMappings("/register");
        registrationBean.setServlet(new RegisterBeanServlet());
        return registrationBean;
    }
}
