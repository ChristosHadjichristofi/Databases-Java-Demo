package com.demo;

/**
 * Message class to save the type and the value of a message
 * used to pass messages to the pages and show them to the user
 */
public class Message {
    public String type;
    public String value;

    /**
     * @param type type of message
     * @param value value of message
     */
    public Message(String type, String value) {
        this.type = type;
        this.value = value;
    }

}