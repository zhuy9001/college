package com.design.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

public class MessageFactory {

    private Map<String,Object> map=new HashMap<>();

    private MessageFactory(){
        map.put("96A",new Pares96AMessage());
        map.put("96B",new Pares96BMessage());
    }

    public Object find(String  key){
       if(map.containsKey(key)){
           return map.get(key);
       }
       return null;
    }

    public static MessageFactory getInstance(){
        return MessageInnerFactory.factory;
    }

    private  static class  MessageInnerFactory{
        private static   final  MessageFactory factory=new MessageFactory();

    }


}
