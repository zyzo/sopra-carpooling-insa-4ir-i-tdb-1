package com.sopride.core.exception;

public class AddressException extends AbstractException{
	
	public AddressException(String forwardingPath, String messageContent) {
		super(forwardingPath, messageContent, AbstractException.ERROR_TYPE);
		// TODO Auto-generated constructor stub
	}
}
