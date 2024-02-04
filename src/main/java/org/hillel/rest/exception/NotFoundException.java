package org.hillel.rest.exception;

import jakarta.ws.rs.WebApplicationException;

public class NotFoundException extends WebApplicationException{
    public NotFoundException(String message) {
        super(message);
    }
}