package com.zzz.dao.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.dao.UserMapper;
import com.zzz.model.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Singleton
public class UserMapperImpl implements UserMapper {

    @Inject
    private SqlSessionManager sqlSessionManager;

    @Override
    public UserVo getByUsername(String username) {
        return sqlSessionManager.selectOne("com.zzz.dao.UserMapper.getByUsername", username);
    }

    @Override
    public List<UserVo> findAll() {
        return sqlSessionManager.selectList("com.zzz.dao.UserMapper.findAll");
    }

}
