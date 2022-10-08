package com.boot.demo.bean.config;

import com.boot.demo.bean.factory.StudentBean;
import com.boot.demo.bean.factory.UserFactoryBean;
import com.boot.demo.bean.simple.ActBean;
import com.boot.demo.bean.simple.BarBean;
import com.boot.demo.bean.simple.CatBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 9:36
 */

@Configuration
public class BeanLoadConfig {

    @Bean
    public CatBean catBean(){
        return new CatBean();
    }

    @Bean
    public ActBean actBean(){
        return new ActBean();
    }

    @Bean
    public BarBean barBean(){
        return new BarBean();
    }

    @Bean
    public StudentBean studentBean(UserFactoryBean userFactoryBean) throws Exception{
        return userFactoryBean.getObject();
    }
}
