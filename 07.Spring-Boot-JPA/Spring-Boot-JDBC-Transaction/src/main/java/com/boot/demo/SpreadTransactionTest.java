package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 事务传播行为测试
 * @date 2022年09月12日 21:48
 */

@Component
public class SpreadTransactionTest {

    @Autowired
    private SpreadTransaction spreadTransaction;

    @Autowired
    private SpreadTransactionExample transactionExample;

    public void test(){

    }

    /**
     * 默认。 当前存在事务则加入，不存在则创建新事物
     */
    private void testRequired() {
        call("Required事务运行", 420, spreadTransaction::required);
    }

    /**
     * 非事务方法,异常不回滚，存在则加入当前事务，不存在则已非事务方式运行
     */
    private void testSupport() {
        // 非事务方式，异常不会回滚
        call("support无事务运行", 460, spreadTransaction::support);
        call("support事务运行", 480, spreadTransaction::support);
    }


    /**
     * 非事务方式运行，如果当前存在事务则暂停当前事务
     */
    private void testNotSupport() {
        int id = 460;
        call("notSupport", id, spreadTransaction::notSupport);
    }


    /**
     * 非事务方式运行，存在事务则加入，不存在事务则抛出异常
     */
    private void testMandatory() {
        call("mandatory非事务运行", 450, spreadTransaction::mandatory);
    }

    /**
     * 非事务方式运行，如果当前存在事务则抛出异常
     */
    private void testNever() {
        call("never非事务", 470, spreadTransaction::never);
    }

    /**
     * 如果没有事务则新建一个事务，如果有则在当前事务中嵌套其他事务
     */
    private void testNested() {
        call("nested事务", 480, spreadTransaction::nested);
        call("nested事务2", 490, spreadTransaction::nested2);
    }


    private void call(String tag, int id, CallFun<Integer> func) {
        System.out.println("============ " + tag + " start ========== ");
        spreadTransaction.query(tag, id);
        try {
            func.apply(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        spreadTransaction.query(tag, id);
        System.out.println("============ " + tag + " end ========== \n");
    }

    @FunctionalInterface
    public interface CallFun<T> {
        void apply(T t) throws Exception;
    }

}
