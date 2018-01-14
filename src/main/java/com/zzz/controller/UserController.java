package com.zzz.controller;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.model.UserVo;
import com.zzz.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author 胡胜钧
 * @date 1/14 0014.
 */
@Slf4j
@Singleton
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService userService;

    @GET
    @Path("/getByUsername")
    public Map<String, Object> getByUsername() {
        UserVo userVo = userService.getByUsername("hsj");
        Map<String , Object> map = Maps.newHashMap();
        map.put("result", userVo);
        return map;
    }

}
