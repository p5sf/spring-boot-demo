package com.boot.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YanZhao
 * @description 编程式事务
 * @date 2022年09月12日 21:25
 */

@Component
@Slf4j
public class TransactionTest {

    @Autowired
    private TransactionExample transactionExample;

    @Autowired
    private ManageTransaction manageTransaction;

    public void test(){
        // 不生效，因为test 方法上没有事务注解
        transactionExample.test();
        System.out.println("-------事务开始start --------");
        transactionExample.query("transaction before", 130);
        try {
            // 事务正常使用
            transactionExample.testRuntimeExceptionTrans(130);
        } catch (Exception e) {
            log.info("---");

        }
        transactionExample.query("transaction end", 130);
        System.out.println("---------事务不生效 start ---------");
        transactionExample.query("transaction before", 140);
        try {
            transactionExample.testNormalException(140);
        } catch (Exception e) {
            log.info("----");
        }
        transactionExample.query("transaction end", 140);
        log.info("----------事务不生效 End----------  \n");

        log.info("-----------事务生效 Start --------------");
        transactionExample.query("transaction before", 150);
        try {
            transactionExample.testSpecialException(150);
        } catch (Exception e) {
            log.info("---------");
        }
        transactionExample.query("transaction end", 150);
        System.out.println("------------事务生效 End\n");
    }

    public void testManual(){
        log.info("----编程式事务 start --------");
        manageTransaction.query("transaction before", 220);
        manageTransaction.testTransaction(220);
        manageTransaction.query("transaction end", 220);
        System.out.println("======= 编程式事务 end ========== ");
    }

}
