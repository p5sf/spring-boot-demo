package com.boot.demo.bean.simple;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 9:34
 */

@Data
@Slf4j
public class ActBean {
    private String type = "ActBean";

    public ActBean() {
        log.info("ActBean load time: {}", System.currentTimeMillis());
    }

    public String getName(String name) {
        return name + " _" + type;
    }
}
