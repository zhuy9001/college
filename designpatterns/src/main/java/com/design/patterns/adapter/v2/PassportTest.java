package com.design.patterns.adapter.v2;

import com.design.patterns.adapter.model.Member;
import com.design.patterns.adapter.model.Result;

public class PassportTest {

    public static void main(String[] args) {

        IPassportForThird passportForThird = new PassportForThirdAdapter();

       Result<Member> result= passportForThird.loginForToken("dsadsa");
        System.out.println("返回code："+result.getCode()+",返回消息："+result.getMsg());
    }
}
