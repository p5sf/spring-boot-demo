package com.demo.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author YanZhao
 * @description 方式二：将Listener当成一个普通的spring bean，
 * spring boot会自动将其包装为ServletListenerRegistrationBean对象
 * @date 2022年09月17日 0:45
 */

@Component
public class BeanContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("bean context 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("bean context 销毁");
    }
}
