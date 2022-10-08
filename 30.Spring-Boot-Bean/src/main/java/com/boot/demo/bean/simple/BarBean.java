package com.boot.demo.bean.simple;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 9:34
 */

@Slf4j
@Component
@Data
public class BarBean {
    private String type = "BarBean";

    public BarBean() {
        log.info("BarBean load time: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " _" + type;
    }
}
