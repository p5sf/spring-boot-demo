package com.demo.bean;

import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 定义一个普通类 依赖MetaBean
 * @date 2022年09月17日 15:55
 */

@Component
public class MetaNormalBean {
    public MetaNormalBean(MetaBean metaBean) {
        System.out.println("a bean : " + metaBean);
    }
}
