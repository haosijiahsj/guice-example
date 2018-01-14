package com.zzz.controller;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.service.ZzzService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author 胡胜钧
 * @date 1/13 0013.
 */
@Slf4j
@Singleton
@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
public class ZzzController {

    @Inject
    private ZzzService zzzService;

    @GET
    @Path("/sayHello")
    public Map<String, Object> sayHello() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("info", zzzService.sayHello());
        return map;
    }

}
