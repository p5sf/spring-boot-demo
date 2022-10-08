package com.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月23日 10:25
 */

@Document(indexName = "user_index",type = "User")
@Data
public class UserEntity {
    @Id
    private String id;
    private String name;
    private int sex;
    private int age;
}
