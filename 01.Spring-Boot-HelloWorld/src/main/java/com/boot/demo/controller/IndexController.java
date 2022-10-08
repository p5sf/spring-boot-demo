package com.boot.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanZhao
 * @description
 * @date 2022年07月08日 7:34
 */

@RestController
public class IndexController {

    @GetMapping("")
    public String Index() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StringUtils.isEmpty(who)) {
            who = "World";
        }
        return String.format("Hello, {}!", who);
    }
}



