package com.boot.demo.bean.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 9:26
 */

@Slf4j
public class StudentBean {
    private final String type = "StudentBean";

    public StudentBean(){
        log.info("StudentBean load time: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " _" + type;
    }
}
