package com.zzz.config;

import com.google.inject.AbstractModule;
import com.zzz.support.mybatis.SqlSessionFactoryProvider;
import com.zzz.support.mybatis.SqlSessionManagerProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
public class MybatisModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(SqlSessionFactory.class).toProvider(SqlSessionFactoryProvider.class);
        this.bind(SqlSessionManager.class).toProvider(SqlSessionManagerProvider.class);
    }

}
