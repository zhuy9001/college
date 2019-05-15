package com.design.patterns.adapter.v1.service;

public class SiginForThirdServiceTest {

    public static void main(String[] args) {
        SiginForThirdService service = new SiginForThirdService();
        service.login("张三","123456");
        service.loginForQQ("154623612");
        service.loginForWechat("36256");
    }
}
