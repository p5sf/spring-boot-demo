package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月15日 22:57
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    public Application(RedisTemplate<String, String> redisTemplate) {
        redisTemplate.opsForValue().get("key");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        while (true) {
            executorService.submit(() -> {
                redisTemplate.opsForValue().get("test");
            });
        }
    }
}
