package com.neo.model;



import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Yan
 * @description:
 */

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class User  {


    /**
     *  @GeneratedValue(strategy = GenerationType.IDENTITY)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "genId")
    @GenericGenerator(name = "genId" ,strategy = "com.neo.utils.generator.AutoGeneratorId")
    @Column(name = "id")
    private Long id;

    @Column(name = "username",nullable = false, unique = true)
    private String username;

    @Column(name = "money")
    private Long money;

    @Column(name = "is_deleted")
    private Byte isDeleted;

    @Column(name = "create_at")
    @CreatedDate
    private Timestamp crateAt;

    @Column(name = "update_at")
    @CreatedDate
    private Timestamp updateAt;

}
