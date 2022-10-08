package com.demo.bean;

import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月17日 15:46
 */

@Component
public class CustomBean {
    public CustomBean() {
        System.out.println("Custom Bean");
    }
}
