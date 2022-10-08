package com.demo.web;

import java.lang.annotation.*;

/**
 * @author Yan
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface PlatForm {

    PlatFormEnum value() default PlatFormEnum.ALL;

}
