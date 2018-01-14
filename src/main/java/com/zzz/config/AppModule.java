package com.zzz.config;

import com.google.inject.AbstractModule;
import com.zzz.config.model.ServerProperties;
import com.zzz.dao.UserMapper;
import com.zzz.dao.ZzzDao;
import com.zzz.dao.impl.UserMapperImpl;
import com.zzz.dao.impl.ZzzDaoImpl;
import com.zzz.service.UserService;
import com.zzz.service.ZzzService;
import com.zzz.service.impl.UserServiceImpl;
import com.zzz.service.impl.ZzzServiceImpl;
import com.zzz.utils.YamlUtils;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(ZzzDao.class).to(ZzzDaoImpl.class);
        this.bind(ZzzService.class).to(ZzzServiceImpl.class);
        this.bind(UserMapper.class).to(UserMapperImpl.class);
        this.bind(UserService.class).to(UserServiceImpl.class);

        this.install(new ResourceModule());
        this.install(new MybatisModule());
    }

}
