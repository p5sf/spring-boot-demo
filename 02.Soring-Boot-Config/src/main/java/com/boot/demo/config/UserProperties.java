package com.boot.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author YanZhao
 * @description 默认加载application.properties
 * @date 2022年07月08日 7:41
 */

@Component
@Data
public class UserProperties {

    @Value("${com.user.userName}")
    private String userName;

    @Value("${com.user.age}")
    private String age;

    @Value("${com.user.desc}")
    private String desc;

    @Value("${com.user.hobby}")
    private List<String> hobby;

    @Value("#{${com.user.address}}")
    private Map<String,String> address;

}
