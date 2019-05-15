package com.design.patterns.proxy.dynamicproxy;

import com.design.patterns.proxy.dynamicproxy.model.Customer;
import com.design.patterns.proxy.dynamicproxy.model.Person;

public class PGLProxyTest {


    public static void main(String[] args) {
        try {
            Person obj = (Person)new PGLSaleOnCommission().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findSell();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
