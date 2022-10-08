package com.xhcoding.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yan
 */
@SpringBootApplication
@RestController
public class SpringBootDemoActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoActuatorApplication.class, args);
    }

    @GetMapping("index")
    public String getIndex(){
        return "Hello";
    }
}
