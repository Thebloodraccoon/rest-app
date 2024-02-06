package org.hillel.rest.exception.handler;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hillel.rest.exception.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class WebExceptionHandler implements ExceptionMapper<WebApplicationException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);

    @Override
    public Response toResponse(WebApplicationException e) {
        String message = "Generic error: " + e.getMessage();

        LOGGER.error("Exception: {} ", message);

        ErrorResponse errorResponse = new ErrorResponse(message);
        return Response.status(e.getResponse().getStatus())
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
