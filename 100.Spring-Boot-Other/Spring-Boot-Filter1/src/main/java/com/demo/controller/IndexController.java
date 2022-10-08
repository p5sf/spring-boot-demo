package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月16日 22:48
 */

@RestController
public class IndexController {

    @GetMapping(path = {"/", "index"})
    public String hello(String name) {
        return "hello " + name;
    }

}
