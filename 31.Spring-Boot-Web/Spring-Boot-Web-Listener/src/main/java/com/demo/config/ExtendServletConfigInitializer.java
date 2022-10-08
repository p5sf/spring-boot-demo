package com.demo.config;


import com.demo.listener.SelfServletListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Yan
 * 方式四
 * 优先级最高
 * 因为ExtendServletConfigInitializer的主动注册时机，在启动时添加了这个Listenrer，所以它的优先级会是最高
 */
@Component
public class ExtendServletConfigInitializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(SelfServletListener.class);
    }
}
