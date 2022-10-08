package com.demo.context;

import com.demo.servlet.ContextServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author YanZhao
 * @description 方式三：
 * @date 2022年09月16日 23:56
 */

@Component
public class ContextServletConfig  implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration initServlet = servletContext.addServlet("contextServlet", ContextServlet.class);
        initServlet.addMapping("/context");
    }
}
