package com.neo.service;

import com.neo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yan
 * 对用户的操作
 */
public interface UserService  {

    void addUser();

    void batchAddUser(User user);

    User findById(Long id);

    void deleteUser(String username);


    void updateUser(Long id);
}
