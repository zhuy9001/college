package com.design.patterns.adapter.v2.adapters;

import com.design.patterns.adapter.model.Member;
import com.design.patterns.adapter.model.Result;

public interface LoginAdapter {

    boolean support(Object object);

    public Result<Member> login(String id, Object adapter);
}
