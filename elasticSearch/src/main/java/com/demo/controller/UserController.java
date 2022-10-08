package com.demo.controller;

import com.demo.entity.UserEntity;
import com.demo.service.UserService;
import org.elasticsearch.action.get.MultiGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月23日 10:46
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("save")
    public UserEntity addUser(){
        UserEntity user = new UserEntity();
        user.setId("1");
        user.setAge(12);
        user.setName("小花");
        user.setSex(1);
        return userService.addUser(user);
    }

    @RequestMapping("/findUser")
    public Optional<UserEntity> findUser(String id) {
        return userService.findUser(id);
    }

    public void test(){
    }
}
