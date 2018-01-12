package com.zzz.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.dao.ZzzDao;
import com.zzz.service.ZzzService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
@Slf4j
@Singleton
public class ZzzServiceImpl implements ZzzService {

    @Inject
    private ZzzDao zzzDao;

    @Override
    public void save() {
        zzzDao.save();
    }

    @Override
    public void update() {
        zzzDao.update();
    }

    @Override
    public void delete() {
        zzzDao.delete();
    }

}
