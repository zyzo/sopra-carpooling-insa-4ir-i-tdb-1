package com.sopride.core.exception;

/**
 * Created by zyzo on 07/01/15.
 */
public class AbstractException extends RuntimeException {

    public static final String ERROR_TYPE = "ERROR";
    public static final String WARNING_TYPE = "WARNING";
    private String forwardingPath;
    private String messageContent;
    private String messageType;


    public AbstractException(String forwardingPath, String messageContent, String messageType) {
        this.forwardingPath = forwardingPath;
        this.messageContent = messageContent;
        this.messageType = messageType;
    }

    public String getForwardingPath() {
        return forwardingPath;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
