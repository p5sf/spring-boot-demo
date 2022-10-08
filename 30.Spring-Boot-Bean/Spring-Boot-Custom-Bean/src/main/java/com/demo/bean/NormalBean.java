package com.demo.bean;

import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 方式二：定义一个普通的Bean
 * @date 2022年09月17日 15:45
 */

@Component
public class NormalBean {
    public NormalBean(){
        System.out.println("Normal Bean");
    }
}
