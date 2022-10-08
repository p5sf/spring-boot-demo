package com.boot.demo.bean.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 9:35
 */

@Slf4j
@Component
public class CatBean {
    private final String type = "CatBean";

    public CatBean() {
        log.info("CatBean load time: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " _" + type;
    }
}
