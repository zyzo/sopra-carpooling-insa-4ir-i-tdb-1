package com.sopride.core.exception;

public class NoUserEmailException extends AbstractException {

	public NoUserEmailException(String forwardingPath, String messageContent) {
        super(forwardingPath, messageContent, AbstractException.ERROR_TYPE);
    }

}
