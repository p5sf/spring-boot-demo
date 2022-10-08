package com.boot.demo.bean.simple;

import com.boot.demo.bean.autoconfig.AutoBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 10:08
 */

@Slf4j
@Component
public class DependBean {

    private final AutoBean autoBean;

    public DependBean(AutoBean autoBean) {
        this.autoBean = autoBean;
        log.info("DependAutoBean load time: {}", System.currentTimeMillis());
    }
}


