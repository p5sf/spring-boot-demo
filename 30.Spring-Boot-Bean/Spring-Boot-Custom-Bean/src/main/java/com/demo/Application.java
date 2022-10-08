package com.demo;

import com.demo.annotation.MetaComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月17日 15:43
 */

@SpringBootApplication
@MetaComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
