package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月22日 15:37
 */

@RestController
public class IndexController {

    @GetMapping("index")
    public String index(){
        return "OK";
    }
}
