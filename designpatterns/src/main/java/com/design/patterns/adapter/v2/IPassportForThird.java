package com.design.patterns.adapter.v2;

import com.design.patterns.adapter.model.Member;
import com.design.patterns.adapter.model.Result;

public interface IPassportForThird {


    /**
     * QQ登录
     * @param id
     * @return
     */
    Result<Member> loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    Result<Member> loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     * @return
     */
    Result<Member> loginForToken(String token);

    /**
     * 新浪微博登录
     * @param
     * @param code
     * @return
     */
    Result<Member> loginForSina(String code);

    /**
     * 注册后自动登录
     * @param username
     * @param passport
     * @return
     */
    Result<Member> loginForRegist(String username, String passport);
}
