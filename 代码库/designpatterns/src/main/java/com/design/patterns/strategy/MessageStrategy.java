package com.design.patterns.strategy;

import com.design.patterns.strategy.model.EDIMessage;

public class MessageStrategy {

    private EDIMessage message;
    private MessageFactory factory;

    public MessageStrategy(EDIMessage message) {
        this.message = message;
        this.factory=MessageFactory.getInstance();
    }

    public  String Pares() {

        String messageType = message.getHead().getType() + message.getHead().getVersion();
        ParesMessage p=(ParesMessage)factory.find(messageType);
        p.pares(message);
        return null;
    }
}
