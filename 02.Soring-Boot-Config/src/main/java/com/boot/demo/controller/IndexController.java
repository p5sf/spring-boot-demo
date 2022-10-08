package com.boot.demo.controller;

import com.boot.demo.config.Person;
import com.boot.demo.config.UserBean;
import com.boot.demo.config.UserProperties;
import com.boot.demo.spel.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YanZhao
 * @description
 * @date 2022年07月08日 7:46
 */

@RestController
public class IndexController {

    @Autowired
    public UserProperties userProperties;

    @Autowired
    public UserBean userBean;


    @Autowired
    private Person person;

    @Autowired
    private Teacher teacher;


    @GetMapping("value")
    public UserProperties User() {
        return userProperties;
    }

    @GetMapping("bean")
    public List<String> show() {
        return userBean.getHobby();
    }


    @GetMapping("properties")
    public Person getPerson() {
        return person;
    }

    @GetMapping("teacher")
    public Teacher getTeacher(){
        return teacher;
    }


}
