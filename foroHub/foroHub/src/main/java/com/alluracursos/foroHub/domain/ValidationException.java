package com.alluracursos.foroHub.domain;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
