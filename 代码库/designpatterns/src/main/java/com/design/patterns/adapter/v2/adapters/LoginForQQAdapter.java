package com.design.patterns.adapter.v2.adapters;

import com.design.patterns.adapter.model.Member;
import com.design.patterns.adapter.model.Result;

public class LoginForQQAdapter implements  LoginAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof  LoginForQQAdapter;
    }

    @Override
    public Result<Member> login(String id, Object adapter) {
        return new Result().createSuccess();
    }
}
