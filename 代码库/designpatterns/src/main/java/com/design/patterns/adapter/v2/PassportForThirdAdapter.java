package com.design.patterns.adapter.v2;

import com.design.patterns.adapter.model.Member;
import com.design.patterns.adapter.model.Result;
import com.design.patterns.adapter.v1.service.SiginServicce;
import com.design.patterns.adapter.v2.adapters.*;

public class PassportForThirdAdapter extends SiginServicce implements  IPassportForThird {
    @Override
    public Result<Member> loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public Result<Member> loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public Result<Member> loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public Result<Member> loginForSina(String sinaId) {
        return processLogin(sinaId, LoginForSinaAdapter.class);
    }

    @Override
    public Result<Member> loginForRegist(String username, String passport) {
        return null;
    }

    private  Result<Member> processLogin(String key, Class<? extends LoginAdapter> clazz){

        try {
            LoginAdapter adapter=clazz.newInstance();
            if(adapter.support(adapter)){
                    return adapter.login(key,adapter);
            }
          } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


}
