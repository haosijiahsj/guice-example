package com.zzz.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zzz.model.UserVo;
import com.zzz.service.UserService;
import com.zzz.support.ResponseEntity;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public ResponseEntity getByUsername(@PathParam("username") String username) {
        try {
            return ResponseEntity.ok(userService.getByUsername(username));
        } catch (Exception e) {
            return ResponseEntity.serverError(e.getMessage());
        }
    }

    @GET
    @Path("/findAll")
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.serverError(e.getMessage());
        }
    }

    @PUT
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity save(String json) {
        try {
            UserVo userVo = JSONObject.parseObject(json, UserVo.class);
            userService.save(userVo);
            return ResponseEntity.noContent();
        } catch (Exception e) {
            return ResponseEntity.serverError(e.getMessage());
        }
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity update(String json) {
        try {
            UserVo userVo = JSONObject.parseObject(json, UserVo.class);
            userService.update(userVo);
            return ResponseEntity.noContent();
        } catch (Exception e) {
            return ResponseEntity.serverError(e.getMessage());
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public ResponseEntity delete(@PathParam("id") Integer id) {
        try {
            userService.delete(id);
            return ResponseEntity.noContent();
        } catch (Exception e) {
            return ResponseEntity.serverError(e.getMessage());
        }
    }

}
