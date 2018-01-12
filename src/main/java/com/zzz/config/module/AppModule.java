package com.zzz.config.module;

import com.google.inject.AbstractModule;
import com.zzz.dao.ZzzDao;
import com.zzz.dao.impl.ZzzDaoImpl;
import com.zzz.service.ZzzService;
import com.zzz.service.impl.ZzzServiceImpl;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(ZzzDao.class).to(ZzzDaoImpl.class);
        this.bind(ZzzService.class).to(ZzzServiceImpl.class);
    }

}
