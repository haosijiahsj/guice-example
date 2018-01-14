package com.zzz.support.mybatis;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.zzz.config.model.MybatisProperties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Singleton
public class SqlSessionFactoryProvider implements Provider<SqlSessionFactory> {

//    @Inject
//    private MybatisProperties mybatisProperties;

    @Override
    public SqlSessionFactory get() {
//        Properties properties = new Properties();
//        properties.setProperty("jdbc.url", mybatisProperties.getUrl());
//        properties.setProperty("jdbc.username", mybatisProperties.getUsername());
//        properties.setProperty("jdbc.password", mybatisProperties.getPassword());

        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("载入mybatis文件：%s失败！"));
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}
