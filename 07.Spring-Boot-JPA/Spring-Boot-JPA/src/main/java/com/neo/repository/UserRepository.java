package com.neo.repository;

import com.neo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameLike(String username);

    List<User> findByUsernameAndMoney(String username, Long money);

    List<User> findByIdLessThanEqual(Long id);

    @Modifying
    @Transactional
    @Query("delete from User where id = ?1")
    void deleteByUsername(String username);


    @Modifying
    @Transactional
    @Query("update User u set u.money=u.money + ?2 where u.id=?1")
    void addMoneyById(Long id, Long money);





//    @Transactional(timeout = 10)
//    @Modifying
//    @Query("update User set username = ?1 where id = ?2")
//    int modifyById(String  userame, Long id);
//
//    @Transactional(timeout = 10)
//    @Modifying
//    @Query("delete from User where id = ?1")
//    void deleteByIds(Long id);
}
