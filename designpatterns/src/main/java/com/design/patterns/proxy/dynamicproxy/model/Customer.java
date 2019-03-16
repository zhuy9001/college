package com.design.patterns.proxy.dynamicproxy.model;

public class Customer implements  Person {
    @Override
    public void findSell() {
        System.out.println("卖五红白菜资历9W成衣100件秀姐");
        System.out.println("卖五红白菜资历9W成衣100件毒姐");
    }
}
