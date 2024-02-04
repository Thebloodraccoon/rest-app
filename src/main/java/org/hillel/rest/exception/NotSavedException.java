package org.hillel.rest.exception;

import jakarta.ws.rs.WebApplicationException;

public class NotSavedException extends WebApplicationException {
    public NotSavedException(String message) {
        super(message);
    }
}
