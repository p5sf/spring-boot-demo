package com.boot.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月11日 18:09
 */



@Data
@Component
@ConfigurationProperties(prefix = "com.users")
public class Person {

    private String name;

    private Integer age;

    private List<String> hobby;

    private Map<String,String> chat;

    private Student student;

    //private Result result;


}
