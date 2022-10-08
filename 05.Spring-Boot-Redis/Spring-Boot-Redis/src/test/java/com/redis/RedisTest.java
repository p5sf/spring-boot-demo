package com.redis;

import com.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * <p>
 * Redis测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 17:17
 */
@Slf4j
public class RedisTest extends SpringBootDemoCacheRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


   @Resource
    private RedisTemplate<String,Serializable> redisCacheTemplate;

    /**
     * 测试 Redis 操作
     */
    @Test
    public void get() {
        // 测试线程安全，程序结束查看redis中count的值是否为1000
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue().increment("count", 1)));
//
//        stringRedisTemplate.opsForValue().set("k1", "v1");
//        String k1 = stringRedisTemplate.opsForValue().get("k1");
//        log.debug("【k1】= {}", k1);
//
//        String key = "user:1";
//        redisCacheTemplate.opsForValue().set(key, new User(1L, "网络"));
//        // 对应 String（字符串）
//        User user = (User) redisCacheTemplate.opsForValue().get(key);
//        log.debug("【user】= {}", user);

        redisCacheTemplate.opsForValue().set("student", "里尔");
        String values = redisCacheTemplate.opsForValue().get("student").toString();
        log.info(values);

    }
}
