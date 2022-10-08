package com.demo.service;

import com.demo.entity.UserEntity;

import java.util.Optional;

/**
 * @author Yan
 */
public interface UserService {

    UserEntity addUser(UserEntity user);

    Optional<UserEntity> findUser(String id);
}
