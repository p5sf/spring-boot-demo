package com.demo.service;

import com.demo.dao.UserRepository;
import com.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月23日 10:45
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> findUser(String id) {
        return userRepository.findById(id);
    }
}
