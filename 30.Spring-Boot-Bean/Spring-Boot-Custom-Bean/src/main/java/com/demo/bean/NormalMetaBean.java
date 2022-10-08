package com.demo.bean;

import com.demo.annotation.Meta;

/**
 * @author YanZhao
 * @description 定义一个Meta 装饰的类，依赖NormalBean
 * @date 2022年09月17日 15:53
 */

@Meta
public class NormalMetaBean {
    public NormalMetaBean(NormalBean normalBean) {
        System.out.println("normal bean" + normalBean);
    }
}
