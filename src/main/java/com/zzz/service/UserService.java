package com.zzz.service;

import com.zzz.model.UserVo;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
public interface UserService {

    UserVo getByUsername(String username);

}
