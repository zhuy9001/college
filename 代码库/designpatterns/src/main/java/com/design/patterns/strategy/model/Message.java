package com.design.patterns.strategy.model;

public class Message {

    private  String type;
    private String MessageName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessageName() {
        return MessageName;
    }

    public void setMessageName(String messageName) {
        MessageName = messageName;
    }
}
