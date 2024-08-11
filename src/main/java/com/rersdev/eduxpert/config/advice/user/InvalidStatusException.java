package com.rersdev.eduxpert.config.advice.user;

public class InvalidStatusException extends RuntimeException {

    public InvalidStatusException(String message) {
        super(message);
    }
}