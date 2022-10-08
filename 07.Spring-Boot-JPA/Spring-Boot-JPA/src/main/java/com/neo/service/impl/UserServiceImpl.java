package com.neo.service.impl;

import com.neo.model.User;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 23:20
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser() {
        // 使用自定义的主键策略，如果不设置默认为数据库自带的主键策略
        User user = new User();
      //  user.setId(20L);
        user.setUsername("小六");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setCrateAt(now);
        user.setUpdateAt(now);
       // User save = userRepository.save(user);
        User rest  = userRepository.saveAndFlush(user);
        log.info("\n"+rest);

    }

    @Override
    public void batchAddUser(User user) {
        User user1 = new User();
        user1.setUsername("王五");
        User user2 = new User();
        user2.setUsername("小九");
        List<User> users = userRepository.saveAll(Arrays.asList(user1, user2));
        System.out.println(users);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        User userByName = userRepository.findByUsername("张三");
        User userLikeName = userRepository.findByUsernameLike("张三");
        List<User> userList = userRepository.findByUsernameAndMoney("张三", 120L);
        List<User> users = userRepository.findAllById(Arrays.asList(1L, 2L));
        List<User> userThan = userRepository.findByIdLessThanEqual(2L);
        log.info(user.get() + "\n" + userLikeName + "\n" + userByName + "\n" + userList + "\n" + users + "\n" + userThan);
        return user.get();
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void updateUser(Long id) {
        userRepository.addMoneyById(id,100L);
    }


}
