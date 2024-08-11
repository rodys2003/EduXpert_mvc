package com.rersdev.eduxpert.config.advice.user;

public class UserNotFoundException extends  RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
