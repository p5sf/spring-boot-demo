package com.demo.config;

import com.demo.listener.ConfigContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author YanZhao
 * @description
 * 方式三：创建Bean
 * @date 2022年09月17日 0:49
 */

public class ServletListenerConfig {

    @Bean
    public ServletListenerRegistrationBean configContextListener() {
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new ConfigContextListener());
        return bean;
    }
}
