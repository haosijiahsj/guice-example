package com.zzz.support;


import lombok.Builder;
import lombok.Data;

import javax.ws.rs.core.Response.Status;
import java.io.Serializable;

/**
 * @author hushengjun
 * @date 2018/1/17
 */
@Data
@Builder
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = 383578243227855964L;

    private Integer code;
    private String msg;
    private Object content;

    public static ResponseEntity ok(Object content) {
        return ResponseEntity.builder()
                .code(Status.OK.getStatusCode())
                .msg(Status.OK.getReasonPhrase())
                .content(content)
                .build();
    }

    public static ResponseEntity noContent() {
        return ResponseEntity.builder()
                .code(Status.NO_CONTENT.getStatusCode())
                .msg(Status.NO_CONTENT.getReasonPhrase())
                .build();
    }

    public static ResponseEntity serverError() {
        return ResponseEntity.builder()
                .code(Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .msg(Status.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
    }

    public static ResponseEntity serverError(String exceptionMsg) {
        return ResponseEntity.builder()
                .code(Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .msg(exceptionMsg)
                .build();
    }

    public static ResponseEntity of(Status status) {
        return ResponseEntity.builder()
                .code(status.getStatusCode())
                .msg(status.getReasonPhrase())
                .build();
    }

}
