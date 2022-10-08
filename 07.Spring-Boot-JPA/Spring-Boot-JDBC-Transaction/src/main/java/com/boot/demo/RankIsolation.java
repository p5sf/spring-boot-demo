package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 14:40
 */

@Component
@Service
public class RankIsolation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        String sql = "replace into money (id, name, money) values (320, '初始化', 200)," + "(330, '初始化', 200)," +
                "(340, '初始化', 200)," + "(350, '初始化', 200)";
        jdbcTemplate.execute(sql);
    }

    /**
     * 串行化隔离级别
     * 只读
     */
    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public boolean serializeReadTransaction(int id) throws InterruptedException {
        this.query("串行化： read only", id);
        Thread.sleep(3000);
        this.query("串行化 ：read only", id);
        return true;
    }

    /**
     * 串行化隔离级别，处理所有问题，但性能低
     */
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public boolean serializeTransaction(int id) {
        if (this.updateName(id)) {
            this.query("串行化: after updateMoney name", id);
            return this.updateMoney(id);
        }

        return false;
    }


    /**
     * 可重复读
     * 只读事务，隔离其他事务的修改对本次操作的影响
     * 比如多次读取表的耗时操作，开启只读事务后，不支持修改数据
     */
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public boolean onlyReadTransaction(int id) throws InterruptedException {
        this.query("可重复读：read only", id);
        Thread.sleep(3000);
        this.query("可重复读：read only", id);
        return true;
    }

    /**
     * 可重复读，读事务禁止其他的写事务，未提交事务，会挂起其他读事务，可避免脏读，不可重复读
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public boolean repeatReadTransaction(int id) {
        if (this.updateMoney(id)) {
            this.query("可重复读：after updateMoney name", id);
            return this.updateMoney(id);
        }
        return false;
    }

    /**
     * 已提交读，测试不可重复读，一个事务两次读取的结果不同
     */
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public boolean onlyReadCommitTransaction(int id) throws InterruptedException {
        this.query("已提交读 read only", id);
        Thread.sleep(1000);
        this.query("已提交读 read only", id);
        Thread.sleep(3000);
        this.query("已提交读 read only", id);
        return true;
    }

    /**
     * 已提交读
     * 未提交的写事务，会挂起其他的读写事务，可避免脏读，更新丢失，但不能防止不可重复读，幻读
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public boolean readCommitTransaction(int id) throws InterruptedException {
        if (this.updateName(id)) {
            this.query("已提交读: after updateMoney name", id);
            Thread.sleep(2000);
            return this.updateMoney(id);
        }
        return false;
    }


    /**
     * 未提交读，测试脏读，会读取到另外一个事务未提交的修改
     */
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public boolean onlyReadUnCommitTransaction(int id) throws InterruptedException {
        this.query("未提交读：read only", id);
        Thread.sleep(1000);
        this.query("未提交读： read only", id);
        return true;
    }

    /**
     * 未提交读，可能出现脏读，不可避免不可重复读，幻读
     */
    @Transactional( isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    public boolean unCommitReadTransaction(int id) throws InterruptedException {
        if (this.updateName(id)) {
            this.query("未提交读：after updateMoney name", id);
            Thread.sleep(20000);
            return this.updateMoney(id);
        }
        return false;
    }

    public void query(String tag, int id) {
        String sql = "select * from money where id=" + id;
        Map map = jdbcTemplate.queryForMap(sql);
        System.out.println(tag + " >>>> " + map);
    }

    private boolean updateName(int id) {
        String sql = "update money set `name`='小明' where id=" + id;
        jdbcTemplate.execute(sql);
        return true;
    }

    private boolean updateMoney(int id) {
        String sql = "update money set `money`= `money` + 10 where id=" + id;
        jdbcTemplate.execute(sql);
        return false;
    }
}
