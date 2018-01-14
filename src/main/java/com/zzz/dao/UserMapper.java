package com.zzz.dao;

import com.zzz.model.UserVo;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
public interface UserMapper {

    UserVo getByUsername(String username);

}
