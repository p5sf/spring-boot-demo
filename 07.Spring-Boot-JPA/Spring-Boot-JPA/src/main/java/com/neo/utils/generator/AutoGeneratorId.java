package com.neo.utils.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * @author YanZhao
 * @description 自定义的主键生成策略，如果填写了主键id，如果数据库中没有这条记录，则新增指定id的记录；否则更新记录
 * 如果不填写主键id，则利用数据库本身的自增策略指定id
 * @date 2022年09月12日 22:31
 */

public class AutoGeneratorId extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);
        if (id != null && Integer.valueOf(id.toString()) > 0) {
            return id;
        } else {
            return super.generate(s, obj);
        }
    }
}
