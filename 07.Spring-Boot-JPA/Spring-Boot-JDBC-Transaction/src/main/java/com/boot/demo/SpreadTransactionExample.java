package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YanZhao
 * @description:事务传播
 * @date 2022年09月12日 21:12
 */

@Component
public class SpreadTransactionExample {

    @Autowired
    private SpreadTransaction spreadTransaction;

    @Transactional(rollbackFor = Exception.class)
    public void support(int id) throws Exception {
        spreadTransaction.support(id);

    }

    @Transactional(rollbackFor = Exception.class)
    public void notSupport(int id) throws Exception {
        // 挂起当前事务，以非事务方式运行
        try {
            spreadTransaction.notSupport(id);
        } catch (Exception e) {
        }

        spreadTransaction.query("notSupportCall: ", id);
        spreadTransaction.updateName(id, "外部更新");
        spreadTransaction.query("notSupportCall: ", id);
        throw new Exception("回滚");
    }

    /**
     * 非事务运行，如果当前存在事务，则抛出异常
     * @param id
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void never(int id) throws Exception {
        spreadTransaction.never(id);
    }

    /**
     * 如果没有则新建一个事务，如果有则在当前事务中嵌套其他事务
     * @param id
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void nested(int id) throws Exception {
        spreadTransaction.updateName(id, "外部事务修改");
        spreadTransaction.query("nestedCall: ", id);
        try {
            spreadTransaction.nested(id);
        } catch (Exception e) {
        }
    }

    /**
     * 嵌套事务，外部回滚，会同步回滚内部事务
     * @param id
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void nested2(int id) throws Exception {
        spreadTransaction.updateName(id, "外部事务修改");
        spreadTransaction.query("nestedCall: ", id);
        spreadTransaction.nested2(id);
        throw new Exception("事务回滚");
    }
}
