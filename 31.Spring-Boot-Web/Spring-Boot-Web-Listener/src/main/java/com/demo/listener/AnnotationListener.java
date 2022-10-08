package com.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author YanZhao
 * @description
 * 方式一：添加@WebListener
 * 因为WebListener注解不是spring的规范，所了识别它需要在启动类上添加@ServletComponentScan
 * @date 2022年09月17日 0:43
 */

@WebListener
public class AnnotationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("@WebListener context 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("@WebListener context 销毁");
    }

}
