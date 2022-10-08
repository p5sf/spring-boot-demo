package com.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by @author yihui in 15:50 19/10/12.
 */
@RestController
public class IndexController {
    @GetMapping(path = {"/", "index"})
    public String hello(String name) {
        return "hello " + name;
    }

}
