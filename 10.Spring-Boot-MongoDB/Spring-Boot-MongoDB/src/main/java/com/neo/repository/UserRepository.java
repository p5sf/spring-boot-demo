package com.neo.repository;

import com.neo.model.User;

/**
 * Created by summer on 2017/5/5.
 */
public interface UserRepository {

    void saveUser(User user);

    User findUserByUserName(String userName);

    long updateUser(User user);

    void deleteUserById(Long id);

}
