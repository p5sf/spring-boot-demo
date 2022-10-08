package com.demo.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 方式一：添加静态的ApplicationContext容器类，通过这个容器获取Bean对象
 * 通用性强，使用范围广，但不优雅
 * @date 2022年09月17日 9:38
 */

@Component
public class SpringContextUtils implements ApplicationContextAware, EnvironmentAware {

    private static ApplicationContext applicationContext;
    private static Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }


    @Override
    public void setEnvironment(Environment environment) {
        SpringContextUtils.environment = environment;
    }

    public static <T> T getBean(Class<T> clz) {
        return applicationContext.getBean(clz);
    }

    public static String getProperty(String key) {
        return environment.getProperty(key);
    }
}
