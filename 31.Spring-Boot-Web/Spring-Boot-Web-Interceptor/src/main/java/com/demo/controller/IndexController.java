package com.demo.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月17日 9:26
 */

@RestController
public class IndexController {

    @GetMapping("show")
    public String show() {

        return "";
    }


}
