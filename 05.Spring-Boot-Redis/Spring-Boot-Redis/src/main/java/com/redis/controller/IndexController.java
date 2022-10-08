package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月17日 22:12
 */

@RestController
public class IndexController {

    @Resource
    private RedisTemplate<String,Serializable> redisCacheTemplate;

    @GetMapping
    public String getMap() {

        redisCacheTemplate.opsForValue().set("ad", "杨戬1");
        return redisCacheTemplate.opsForValue().get("ad").toString();
    }
}
