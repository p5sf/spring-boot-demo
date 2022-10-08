package com.boot.demo.bean.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 10:10
 */

@Slf4j
@Component
public class AutoBean {

    private final String name;

    public AutoBean(){
        this("defaultAutoBean");
    }

    public AutoBean(String name) {
        this.name = name;
        log.info("AutoBean load time: {}", System.currentTimeMillis());
    }

    public String getName(){
        return name;
    }
}
