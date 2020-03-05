package com.design.patterns.decorator;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname Test
 * @PackageName com.design.patterns.decorator
 * @Date 2020/3/5 14:18
 */
public class Test {
	public static void main(String[] args) {
		Bar bar=new BaseBar();
		LoginBarDecorate loginBarDecorate=new LoginBarDecorate(bar);
		AdminBarDecorate adminBarDecorate=new AdminBarDecorate(loginBarDecorate);
		System.out.println("未登陆："+bar.getBar());
		System.out.println("已登陆："+loginBarDecorate.getBar());
		System.out.println("管理员登陆："+adminBarDecorate.getBar());
	}
}
