package com.design.patterns.decorator;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname LoginBarDecorate
 * @PackageName com.design.patterns.decorator
 * @Date 2020/3/5 14:09
 */
public class LoginBarDecorate extends  BarDecorate {


	public LoginBarDecorate(Bar bar) {
		super(bar);
	}

	@Override
	public String getBar() {
		return super.getBar()+"、作业、题库、成长墙";
	}
}
