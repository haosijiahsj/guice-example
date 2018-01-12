package com.zzz.dao.impl;

import com.google.inject.Singleton;
import com.zzz.dao.ZzzDao;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
@Slf4j
@Singleton
public class ZzzDaoImpl implements ZzzDao {

    @Override
    public void save() {
        log.info("save...");
    }

    @Override
    public void update() {
        log.info("update...");
    }

    @Override
    public void delete() {
        log.info("delete...");
    }

}
