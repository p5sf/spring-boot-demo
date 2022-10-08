package com.demo.dao;

import com.demo.entity.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Yan
 */
public interface UserRepository extends ElasticsearchCrudRepository<UserEntity, String> {
}
