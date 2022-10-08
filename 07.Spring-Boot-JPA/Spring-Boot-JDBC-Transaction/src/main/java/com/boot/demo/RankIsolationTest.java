package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 测试事务
 * @date 2022年09月12日 15:36
 */

@Component
public class RankIsolationTest {

    @Autowired
    private RankIsolation rankIsolation;

    public void testIsolation() throws InterruptedException {
        this.serializeTest();
        Thread.sleep(2000);

        this.onlyReadTest();
        Thread.sleep(2000);

        this.readCommitTest();
        Thread.sleep(2000);

        this.unReadCommitTest();
        Thread.sleep(2000);

    }

    /**
     * serialize隔离级别
     */
    private void serializeTest() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                call("serialize:只读事务", 330, rankIsolation::serializeReadTransaction);
            }
        }).start();
        call("Serialize 读写事务 - read", 330, rankIsolation::serializeTransaction);
    }

    /**
     * 可重复读 只读
     */
    private void onlyReadTest() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                call("可重复读:只读事务", 30, rankIsolation::onlyReadTransaction);
            }
        }).start();

        Thread.sleep(1000);
        call("可重复读 读写事务 - read", 330, rankIsolation::repeatReadTransaction);
    }

    /**
     * read commit 已提交读
     */
    private void readCommitTest() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                call("已提交读:只读事务", 30, rankIsolation::readCommitTransaction);
            }
        }).start();
        Thread.sleep(1000);
        call("已提交读 读写事务 - read", 330, rankIsolation::onlyReadCommitTransaction);
    }


    /**
     * read unCommit 未提交读
     */
    private void unReadCommitTest() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                call("未提交读:只读事务", 30, rankIsolation::unCommitReadTransaction);
            }
        }).start();
        call("未提交读 读写事务 - read", 330, rankIsolation::onlyReadUnCommitTransaction);
    }




    private void call(String tag, int id, CallFun<Integer, Boolean> fun) {
        System.out.println("======" + tag + "start========");
        try {
            fun.apply(id);
        } catch (Exception e) {

        }
        System.out.println("========" + tag + "end===========");
    }

    @FunctionalInterface
    public interface CallFun<T, R> {
        R apply(T t) throws Exception;
    }

}
