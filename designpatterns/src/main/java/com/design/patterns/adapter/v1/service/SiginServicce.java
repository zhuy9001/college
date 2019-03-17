package com.design.patterns.adapter.v1.service;

import com.design.patterns.adapter.model.Result;
import com.design.patterns.adapter.model.Member;

public class SiginServicce {

    /**
     * 注册方法
     * @param userName
     * @param password
     * @return
     */
    public Result<Member> regist(String userName, String password) {
        Member member=new Member();
        member.setUserName(userName);
        member.setPassword(password);
        System.out.println(userName.toString());
        return new Result().createSuccess(member);
    }



    /**
     * 注册方法
     * @param userName
     * @param password
     * @return
     */
    public Result<Member> login(String userName, String password) {
        System.out.println(userName.toString());
        return new Result().createSuccess();
    }
}
