package com.zzz.support;


import lombok.Builder;

import javax.ws.rs.core.Response.Status;

/**
 * @author hushengjun
 * @date 2018/1/17
 */
@Builder
public class ResponseEntity {

    private Integer code;
    private String msg;
    private Object content;

    public static ResponseEntity ok(Object content) {
        return ResponseEntity.builder()
                .code(Status.OK.getStatusCode())
                .msg((Status.OK.getReasonPhrase()))
                .content(content)
                .build();
    }

    public static ResponseEntity noContent() {
        return ResponseEntity.builder()
                .code(Status.NO_CONTENT.getStatusCode())
                .msg((Status.NO_CONTENT.getReasonPhrase()))
                .build();
    }

}
