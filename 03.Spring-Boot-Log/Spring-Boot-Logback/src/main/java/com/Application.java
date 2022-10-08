package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2021-12-24 15:10
 * @Description
 * @author Yan
 */

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.error("Hello World");
        log.warn("Hello World");
        log.info("Hello World");
        log.debug("Hello World");
        log.trace("Hello World");
    }

    @RestController
    static class index {

        @GetMapping("/")
        private String index() {
            return "hello world";
        }
    }
}
