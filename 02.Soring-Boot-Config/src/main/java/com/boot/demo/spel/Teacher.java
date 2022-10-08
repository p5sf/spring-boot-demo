package com.boot.demo.spel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 0:05
 */

@Data
@Component
public class Teacher {

    @Value("张三")
    private String name;

    @Value("#{1+2}")
    private int age;

    @Value("#{RandomSalary.getUUID()}")
    private String salary;


}
