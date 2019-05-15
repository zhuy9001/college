package com.design.patterns.strategy;

import com.design.patterns.strategy.model.Body;
import com.design.patterns.strategy.model.EDIMessage;
import com.design.patterns.strategy.model.Head;
import com.design.patterns.strategy.model.Message;

public class Test {

    public static void main(String[] args) {
        EDIMessage ediMessage = new EDIMessage();
        Body body = new Body();
        Head head = new Head();
        Message message = new Message();
        head.setType("96");
        head.setVersion("B");
        ediMessage.setHead(head);
        message.setMessageName("EDI96");
        message.setType("D");

        body.setMessage(message);
        body.setObject(new Object());
        ediMessage.setBody(body);

        MessageStrategy strategy=new MessageStrategy(ediMessage);
        strategy.Pares();

    }
}
