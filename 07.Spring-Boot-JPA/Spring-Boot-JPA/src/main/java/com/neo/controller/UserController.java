package com.neo.controller;

import com.neo.model.User;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 23:17
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("addUser")
    public String addUser() {
        userService.addUser();
        return "OK";
    }

    @GetMapping("batchAddUser")
    public void batchAddUser() {
        User user = new User();
        userService.batchAddUser(user);
    }

    @GetMapping("delete")
    public void deleteUser(String username) {
        userService.deleteUser(username);

    }

    @GetMapping("query")
    public User queryUser(Long id) {
         return userService.findById(id);
    }

    @GetMapping("update")
    public void updateUser(Long id) {
        userService.updateUser(id);
    }
}
