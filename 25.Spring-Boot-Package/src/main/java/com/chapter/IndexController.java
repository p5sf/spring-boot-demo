package com.chapter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 2021-12-16 11:32
 * @Description TODO
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("index", "Hello World!!!");
        return "index";
    }
}
