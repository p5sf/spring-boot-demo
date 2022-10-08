package com.demo.web;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月16日 15:13
 */


public class PlatFormHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        return buildFrom(AnnotationUtils.findAnnotation(handlerType, PlatForm.class));
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return buildFrom(AnnotationUtils.findAnnotation(method, PlatForm.class));
    }

    private PlatFormRequestCondition buildFrom(PlatForm platform) {
        return platform == null ? null : new PlatFormRequestCondition(platform.value());
    }
}
