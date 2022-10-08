package com.demo.annotation;


import java.lang.annotation.*;

/**
 * @author Yan
 * 添加自定义扫描注解 类似Component注解的功能
 * @Component，@Service, @Repository 装饰类，它会通过自动扫描注册为bean
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Meta {
}
