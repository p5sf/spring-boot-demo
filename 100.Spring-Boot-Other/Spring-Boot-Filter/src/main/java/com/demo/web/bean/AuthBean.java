package com.demo.web.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Yan
 * 如果使用SpringMVC + web.xml方式来定义Filter,自定义的Filter中无法通过@Autowired方式来注入Spring的bean。
 * 可以将Filter封装成了一个Bean对象，因此可以直接注入依赖的Bean
 */

@Data
@Component
public class AuthBean {

    private long time;

    public AuthBean() {
        time = System.currentTimeMillis();
    }

    public void show() {
        System.out.println("auth bean!!! " + time);
    }

}
