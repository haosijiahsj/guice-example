package com.zzz.dao.impl;

import com.google.inject.Inject;
import com.zzz.dao.UserMapper;
import com.zzz.model.UserVo;
import org.apache.ibatis.session.SqlSessionManager;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
public class UserMapperImpl implements UserMapper {

    @Inject
    private SqlSessionManager sqlSessionManager;

    @Override
    public UserVo getByUsername(String username) {
        return sqlSessionManager.getMapper(UserMapper.class).getByUsername(username);
    }

}
