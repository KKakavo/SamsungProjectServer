package com.samsung.samsungProjectServer.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
