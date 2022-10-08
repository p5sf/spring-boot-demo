package com.boot.error;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 测试事务不生效
 * @date 2022年09月12日 16:21
 */



@Slf4j
public class NoEffectTest {

    @Autowired
    private NoEffectTransaction effectTransaction;


    /**
     * 不生效的几种姿势：
     * - 私有方法上，不生效
     * - 内部调用，不生效
     * - 未抛运行异常，不生效
     * - 子线程处理任务，某个线程执行异常，不生效
     */

    public void test(){
        testCall(520,(id)->effectTransaction.invokeTest(520));
        testCall(520,(id)->effectTransaction.callTest(520));
        testCall(520,(id)->effectTransaction.threadTest(520));
        testCall(520, (id) -> effectTransaction.exceptionTest(520));


    }

    public void testCall(int id, CallFun<Integer, Boolean> fun) {
        System.out.println("事务不生效start");
        effectTransaction.query("transaction before", id);
        try {
            fun.apply(id);
        } catch (Exception e) {
            log.info("transaction",id);
        }
        effectTransaction.query("transaction end", id);
    }

    @FunctionalInterface
    public interface CallFun<T, R> {
        R apply(T t) throws Exception;
    }

}
