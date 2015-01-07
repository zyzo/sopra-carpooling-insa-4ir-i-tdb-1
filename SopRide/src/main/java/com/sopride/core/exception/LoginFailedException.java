package com.sopride.core.exception;

/**
 * Created by zyzo on 23/12/14.
 */
public class LoginFailedException extends AbstractException {

    public LoginFailedException(String forwardingPath, String messageContent) {
        super(forwardingPath, messageContent, AbstractException.ERROR_TYPE);
    }
}
