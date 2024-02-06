package org.hillel.rest.exception.handler;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hillel.rest.exception.NotSavedException;
import org.hillel.rest.exception.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class NotSavedExceptionHandler implements ExceptionMapper<NotSavedException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotSavedExceptionHandler.class);

    @Override
    public Response toResponse(NotSavedException e) {
        String message = e.getMessage();

        LOGGER.error("Exception: {} ", message);

        ErrorResponse errorResponse = new ErrorResponse(message);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}