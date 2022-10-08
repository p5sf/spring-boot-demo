package com.demo.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月16日 15:15
 */

public class PlatFormRequestCondition implements RequestCondition<PlatFormRequestCondition> {

    @Getter
    @Setter
    private PlatFormEnum platFormEnum;

    public PlatFormRequestCondition(PlatFormEnum platFormEnum) {
        this.platFormEnum = platFormEnum;
    }

    /**
     * 采用最后定义优先原则，则方法上定义覆盖类上面的定义
     */
    @Override
    public PlatFormRequestCondition combine(PlatFormRequestCondition platFormRequestCondition) {
        return new PlatFormRequestCondition(platFormRequestCondition.platFormEnum);
    }

    @Override
    public PlatFormRequestCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        PlatFormEnum platFormEnum = this.getPlatFormEnum(httpServletRequest);
        if (this.platFormEnum.equals(platFormEnum)) {
            return this;
        }
        return null;
    }

    @Override
    public int compareTo(PlatFormRequestCondition platFormRequestCondition, HttpServletRequest httpServletRequest) {
        return this.platFormEnum.getOrder() - platFormRequestCondition.platFormEnum.getOrder();
    }

    private  PlatFormEnum getPlatFormEnum(HttpServletRequest request) {
        String platForm = request.getHeader("x-platform");
        return PlatFormEnum.nameOf(platForm);
    }
}
