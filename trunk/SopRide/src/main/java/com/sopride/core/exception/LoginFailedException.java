package com.sopride.core.exception;

/**
 * Created by zyzo on 23/12/14.
 */
public class LoginFailedException extends RuntimeException {

    public LoginFailedException(String message) {
        super(message);
    }
}
