package com.zzz.support.mybatis;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Singleton
public class SqlSessionManagerProvider implements Provider<SqlSessionManager> {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public SqlSessionManager get() {
        return SqlSessionManager.newInstance(sqlSessionFactory);
    }

}
