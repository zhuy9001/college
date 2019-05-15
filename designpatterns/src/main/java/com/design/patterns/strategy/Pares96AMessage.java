package com.design.patterns.strategy;

import com.design.patterns.strategy.model.Body;
import com.design.patterns.strategy.model.EDIMessage;
import com.design.patterns.strategy.model.Message;

public class Pares96AMessage implements  ParesMessage{

    private  String  config;//模拟配置文件类

    public  Pares96AMessage(){
        init();
    }

    private void init() {
        this.config="配置文件96A";

    }

    @Override
    public String pares(EDIMessage message) {
        Body body=message.getBody();
        Message mess=body.getMessage();
        System.out.println(mess.getMessageName()+":::"+mess.getType());
        System.out.println(this.config);
        body.getObject();
        return mess.getMessageName();
    }
}
