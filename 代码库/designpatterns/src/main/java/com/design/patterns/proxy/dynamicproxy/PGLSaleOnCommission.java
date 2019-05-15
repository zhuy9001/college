package com.design.patterns.proxy.dynamicproxy;

import java.lang.reflect.Method;

public class PGLSaleOnCommission implements PGLInvocationHandler {

    private  Object object;

    public Object getInstance(Object object) throws  Exception{
        this.object=object;
        Class<?> clazz=object.getClass();
        return PGLProxy.newProxyInstance(new PGLClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object obj=method.invoke(this.object,args);
        this.after();
        return obj;
    }

    private void before(){
        System.out.println("我是代售，现在已经确认你要卖的东西");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备交易");
    }
}
