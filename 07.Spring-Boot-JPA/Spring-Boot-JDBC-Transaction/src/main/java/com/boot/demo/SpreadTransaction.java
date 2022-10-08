package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author YanZhao
 * @description 事务传播行为
 * https://www.cainiaojc.com/note/qa3duu.html
 * @date 2022年09月12日 21:02
 */

@Component
public class SpreadTransaction {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        String sql = "replace into money (id, name, money) values (420, '初始化', 200)," + "(430, '初始化', 200)," +
                "(440, '初始化', 200)," + "(450, '初始化', 200)," + "(460, '初始化', 200)," + "(470, '初始化', 200)," +
                "(480, '初始化', 200)," + "(490, '初始化', 200)";
        jdbcTemplate.execute(sql);
    }

    /**
     * 默认传播行为
     * 如果存在一个事务，则支持当前事务，如果没有事务则开启一个新事务
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void required(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("required: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }
        throw new Exception("事务回滚!!!");
    }

    /**
     * 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行
     */
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public void support(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("support: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }

        throw new Exception("事务回滚!!!");
    }




    /**
     * 需要在一个正常的事务内执行，否则抛异常
     */
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void mandatory(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("mandatory: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }

        throw new Exception("事务回滚!!!");
    }


    /**
     * 总是非事务地执行，并挂起任何存在的事务
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void notSupport(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("notSupport: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }
        throw new Exception("回滚!");
    }

    /**
     * 总是非事务地执行，如果存在一个活动事务，则抛出异常。
     */
    @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public void never(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("notSupport: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }
    }




    /**
     * 如果不存在事务，则开启一个事务运行，如果存在事务，则运行一个嵌套事务
     * 嵌套事务：外部事务回滚，内部事务也会被回滚；内部事务异常，外部无问题，并不会回滚外部事务
     */
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void nested(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("nested: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }

        throw new Exception("事务回滚!!!");
    }



    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void nested2(int id) throws Exception {
        if (this.updateName(id)) {
            this.query("nested: after updateMoney name", id);
            if (this.updateMoney(id)) {
                return;
            }
        }
    }


    private boolean updateName(int id) {
        return updateName(id, "更新");
    }

    public boolean updateName(int id, String name) {
        String sql = "update money set `name`='" + name + "' where id=" + id;
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
