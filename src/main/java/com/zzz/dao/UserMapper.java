package com.zzz.dao;

import com.zzz.model.UserVo;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
public interface UserMapper {

    UserVo getByUsername(String username);

    List<UserVo> findAll();

}
