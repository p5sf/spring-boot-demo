package com.boot.api;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author yihui
 * @date 21/5/24
 */
public interface TransApi {

    @Transactional(rollbackFor = Exception.class)
    boolean update(int id);

}
