package com.sopride.core.exception;

import com.sopride.web.util.WebConstants;

public class AddRideshareException extends AbstractException {

	private static final long serialVersionUID = 1L;

	public AddRideshareException(String forwardingPath, String messageContent) {
		super(forwardingPath, messageContent, AbstractException.WARNING_TYPE);
	}

}
