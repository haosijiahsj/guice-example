package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.mapper.UserMapper;
import com.zzz.model.UserVo;
import com.zzz.service.UserService;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Singleton
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    private UserMapper userMapper;

    @Override
    public UserVo getByUsername(String username) {
        Preconditions.checkNotNull(username, "入参username不能为空！");
        return userMapper.getByUsername(username);
    }

    @Override
    public List<UserVo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(UserVo userVo) {
        Preconditions.checkNotNull(userVo, "入参userVo不能为空！");

        userMapper.save(userVo);
    }

    @Override
    public void update(UserVo userVo) {
        Preconditions.checkNotNull(userVo, "入参userVo不能为空！");

        userMapper.update(userVo);
    }

    @Override
    public void delete(Integer id) {
        Preconditions.checkNotNull(id, "入参id不能为空！");

        userMapper.delete(id);
    }

}
