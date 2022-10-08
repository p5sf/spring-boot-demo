package com.boot.demo.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 9:25
 */

@Component
public class UserFactoryBean implements FactoryBean<StudentBean> {

    @Override
    public StudentBean getObject() throws Exception {
        return new StudentBean();
    }

    @Override
    public Class<?> getObjectType() {
        return StudentBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
