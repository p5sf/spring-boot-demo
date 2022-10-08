package com.demo.interceptor;

import com.demo.bean.InterceptorBean;
import com.demo.context.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author YanZhao
 * @description 自定义拦截器
 * @date 2022年09月17日 9:23
 */

@Slf4j
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private Environment environment;

    /**
     * 在handler 方法执行前执行，如果返回true则拦截通过，如果为false则不允许往后走
     * 因此可以做安全校验，用户身份处理等操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 安全校验，要求请求头中必须包含 req-name : auth
        String header = request.getHeader("req-name");
        if (Objects.equals(environment.getProperty("security.check"), header)) {
            return true;
        }

        // 方式一：获取bean 对象
        if (Objects.equals(SpringContextUtils.getProperty("security.check"), header)) {
            return true;
        }




        log.info("请求头错误: {}", header);
        return false;
    }

    /**
     * handler 方法执行之后，可以操作ModelAndView添加信息
     */
    @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView) throws Exception {
        log.info("执行完毕!");
        response.setHeader("res", "postHandler");
    }

    /**
     * 方法需要在当前对应的 Interceptor 类的 preHandle 方法返回值为 true 时才会执行。
     * 顾名思义，该方法将在整个请求结束之后，也就是在 DispatcherServlet 渲染了对应的视图之后执行。此方法主要用来进行资源清理。
     *
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("回收");
    }

}
