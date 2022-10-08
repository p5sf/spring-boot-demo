package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月12日 21:21
 */

@Component
public class TransactionExample {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        String sql = "replace into money (id, name, money) values (120, '初始化', 200)," +
                "(130, '初始化', 200)," +
                "(140, '初始化', 200)," +
                "(150, '初始化', 200)";
        jdbcTemplate.execute(sql);
    }

    public void test() {
        System.out.println("============ 事务不生效 start ========== ");
        query("transaction before", 120);
        try {
            testRuntimeExceptionTrans(120);
        } catch (Exception e) {

        }
        query("transaction end", 120);
        System.out.println("============ 事务不生效 end ========== \n");
    }

    /**
     * 运行异常导致回滚
     * @param id
     * @return
     */
    @Transactional
    public boolean testRuntimeExceptionTrans(int id) {
        if (this.updateName(id)) {
            this.query("after updateMoney name", id);
            if (this.updateMoney(id)) {
                return true;
            }
        }

        throw new RuntimeException("更新失败，回滚!");
    }

    @Transactional
    public boolean testNormalException(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("after updateMoney name", id);
            if (this.updateMoney(id)) {
                return true;
            }
        }

        throw new Exception("声明异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean testSpecialException(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("after updateMoney name", id);
            if (this.updateMoney(id)) {
                return true;
            }
        }

        throw new IllegalArgumentException("参数异常");
    }

    private boolean updateName(int id) {
        String sql = "update money set `name`='更新' where id=" + id;
        jdbcTemplate.execute(sql);
        return true;
    }

    public void query(String tag, int id) {
        String sql = "select * from money where id=" + id;
        Map map = jdbcTemplate.queryForMap(sql);
        System.out.println(tag + " >>>> " + map);
    }

    private boolean updateMoney(int id) {
        String sql = "update money set `money`= `money` + 10 where id=" + id;
        jdbcTemplate.execute(sql);
        return false;
    }
}
