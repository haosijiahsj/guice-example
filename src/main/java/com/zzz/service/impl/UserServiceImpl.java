package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.zzz.dao.UserMapper;
import com.zzz.model.UserVo;
import com.zzz.service.UserService;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
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

}
