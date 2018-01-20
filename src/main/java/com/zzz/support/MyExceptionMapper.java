package com.zzz.support;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author 胡胜钧
 * @date 1/19 0019.
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof NotAllowedException) {
            return Response.status(Status.METHOD_NOT_ALLOWED)
                    .entity(ResponseEntity.of(Status.METHOD_NOT_ALLOWED))
                    .build();
        }
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .entity(ResponseEntity.serverError(exception.getMessage()))
                .build();
    }

}
