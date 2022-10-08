package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author YanZhao
 * @description 方式一：使用注解方式注册一个Servlet
 * 需要配合@ServletComponentScan，否则不生效
 * @date 2022年09月16日 23:11
 */

@WebServlet(urlPatterns = "/annotation")
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        writer.write("[AnnotationServlet] welcome " + name);
        writer.flush();
        writer.close();
    }
}
