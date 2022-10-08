package com.boot.demo.spel;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 0:10
 */

@Service
public class RandomSalary {


    public String getUUID(){
        Random random = new Random();
        return random.toString();
    }
}
