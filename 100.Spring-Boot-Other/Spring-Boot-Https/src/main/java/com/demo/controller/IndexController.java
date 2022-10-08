package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月18日 16:42
 */

@RestController
public class IndexController {

    @GetMapping
    public String index(){
        return "Hello-World";
    }
}
