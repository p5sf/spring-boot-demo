package com.chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yan
 * @Date 2021-12-21 21:39
 * @Description TODO
 */


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public User index() {
        User user = new User();
        user.setAge(12);
        user.setName("TOM");
        user.setEmail("1770285990@qq.com");
        return user;
    }

    @PostMapping("create")
    public String create() {
        userService.create(10, "TOM", 12);
        return "创建用户成功";
    }

    @GetMapping("find")
    public List<User> findUserByName() {
        return userService.getByName("TOM");
    }

    @GetMapping("account")
    public String findAllUser() {
        int allUsers = userService.getAllUsers();
        return "用户总数为" + allUsers;
    }

    @GetMapping("delete")
    public String delUser() {
        userService.deleteByName("TOM");
        return "删除用户成功";
    }

    @GetMapping("delAll")
    public String delAllUser() {
        int i = userService.deleteAllUsers();
        return "删除所有用户成功";
    }
}
