package com.demo.bean;

import com.demo.annotation.Meta;

/**
 * @author YanZhao
 * @description 方式一：添加自定义注解Meta声明一个类为bean
 *
 * @date 2022年09月17日 15:49
 */

@Meta
public class MetaBean {
    public MetaBean() {
        System.out.println("Meta bean");
    }
}
