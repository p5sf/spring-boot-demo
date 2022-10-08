package com.demo.controller;

import com.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YanZhao
 * @description
 * @date 2022年09月17日 19:59
 */

@RestController
public class IndexController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public Object add(){
        redisTemplate.opsForValue().set("thies", "发顺丰");
       return redisTemplate.opsForValue().get("users");

    }
}
