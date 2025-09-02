package com.bookwise_api.infrastructure.exceptions;


public class NoFieldsToUpdateException extends RuntimeException {
    public NoFieldsToUpdateException(String message) {
        super(message);
    }
}

