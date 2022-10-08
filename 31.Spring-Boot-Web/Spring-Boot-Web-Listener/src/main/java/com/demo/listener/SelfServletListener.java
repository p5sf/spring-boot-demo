package com.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author YanZhao
 * @description 方式四：添加Filter、servlet、listener
 * @date 2022年09月17日 0:53
 */

public class SelfServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextInitializer context 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextInitializer context 销毁");
    }
}
