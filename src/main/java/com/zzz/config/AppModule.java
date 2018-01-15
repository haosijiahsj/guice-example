package com.zzz.config;

import com.google.inject.AbstractModule;
import com.zzz.service.UserService;
import com.zzz.service.impl.UserServiceImpl;
import org.mybatis.guice.XMLMyBatisModule;

/**
 * @author hushengjun
 * @date 2018/1/9
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(UserService.class).to(UserServiceImpl.class);

        this.install(new ResourceModule());
        // 默认指定的是mybatis-config.xml
        // 不需要绑定mapper，mybatis-guice已经绑定好了
        this.install(new XMLMyBatisModule() {
            @Override
            protected void initialize() {}
        });
    }

}
