package com.zzz.controller;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.model.UserVo;
import com.zzz.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Path("/getByUsername/{username}")
    public Response getByUsername(@PathParam("username") String username) {
        try {
            return Response.ok(userService.getByUsername(username)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/findAll")
    public Response findAll() {
        try {
            return Response.ok(userService.findAll()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/save")
    public Response save() {
        try {
            UserVo userVo = new UserVo();
            userVo.setUsername("hsj");
            userVo.setPassword("123123");
            userService.save(userVo);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/update")
    public Response update() {
        try {
            UserVo userVo = new UserVo();
            userVo.setId(1);
            userVo.setUsername("hhssjj");
            userVo.setPassword("123123");
            userService.update(userVo);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
