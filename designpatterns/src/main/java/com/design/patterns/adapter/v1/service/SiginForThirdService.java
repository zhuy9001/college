package com.design.patterns.adapter.v1.service;

import com.design.patterns.adapter.model.Result;
import com.design.patterns.adapter.model.Member;

public class SiginForThirdService extends  SiginServicce {

    public Result<Member> loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }

    public  Result<Member> loginForWechat(String openId){
        return null;
    }

    public  Result<Member> loginForToken(String token){
        //通过token拿到用户信息，然后再重新登陆了一次
        return  null;
    }

    public  Result<Member> loginForTelphone(String telphone,String code){

        return null;
    }

    public  Result<Member> loginForRegist(String username,String password){
        super.regist(username,null);
        return super.login(username,null);
    }
}
