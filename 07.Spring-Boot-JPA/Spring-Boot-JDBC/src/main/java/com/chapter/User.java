package com.chapter;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021-12-21 21:34
 * @Description TODO
 */

@Data
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
}
