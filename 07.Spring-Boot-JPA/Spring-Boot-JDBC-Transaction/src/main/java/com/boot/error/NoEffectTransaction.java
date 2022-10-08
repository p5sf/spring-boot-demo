package com.boot.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author YanZhao
 * @description 事务不生效的案例
 * @date 2022年09月12日 11:44
 */


@Component
public class NoEffectTransaction {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        String sql = "replace into money (id, name, money) values" + " (520, '初始化', 200)," + "(530, '初始化', 200)," +
                "(540, '初始化', 200)," + "(550, '初始化', 200)";
        jdbcTemplate.execute(sql);
    }

    /**
     * 非运行异常，且没有通过rollBackFor 指定抛出异常，不生效
     */
    @Transactional()
    public boolean exceptionTest(int id) throws Exception {
        if (this.update(id)) {
            this.query("after update name", id);
            if (this.update(id)) {
                return true;
            }
        }

        throw new Exception("参数异常");
    }

    /**
     * 非直接调用事务不生效
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean invokeTest(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("after update name", id);
            if (this.update(id)) {
                return true;
            }
        }

        throw new Exception("参数异常");
    }


    public boolean callTest(int id) throws Exception {
        return invokeTest(id);
    }

    /**
     * 子线程抛出异常，主线程无法捕获，导致事务不生效
     */
    public boolean threadTest(int id) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                update(id);
                query("after update name", id);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean ans = update(id);
                query("after update name", id);
                if (!ans) {
                    throw new RuntimeException("failed to update ans");
                }
            }
        }).start();
        Thread.sleep(1000);
        System.out.println("子线程");
        return true;
    }

    /**
     * 测试私有方法事务不生效
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    private boolean prvTest(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("after update name", id);
            if (this.update(id)) {
                return true;
            }
        }
        throw new Exception("参数异常");
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

    private boolean update(int id) {
        String sql = "update money set `money`= `money` + 10 where id=" + id;
        jdbcTemplate.execute(sql);
        return false;
    }
}
