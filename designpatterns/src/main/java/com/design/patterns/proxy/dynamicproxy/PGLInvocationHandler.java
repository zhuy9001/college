package com.design.patterns.proxy.dynamicproxy;

import java.lang.reflect.Method;

public interface PGLInvocationHandler {

    public  Object invoke(Object proxy, Method method,Object[] args) throws  Throwable;
}
