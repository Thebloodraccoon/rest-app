package org.hillel.rest.exception.handler;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hillel.rest.exception.NotFoundException;
import org.hillel.rest.exception.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotFoundExceptionHandler.class);

    @Override
    public Response toResponse(NotFoundException e) {
        String message = e.getMessage();

        LOGGER.error("Exception: {} ", message);


        ErrorResponse errorResponse = new ErrorResponse(message);
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}