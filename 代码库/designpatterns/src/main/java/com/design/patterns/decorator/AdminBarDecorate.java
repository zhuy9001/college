package com.design.patterns.decorator;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname VIPBarDecorate
 * @PackageName com.design.patterns.decorator
 * @Date 2020/3/5 14:12
 */
public class AdminBarDecorate extends  BarDecorate {

	public AdminBarDecorate(Bar bar) {
		super(bar);
	}

	@Override
	public String getBar() {
		return super.getBar()+"、管理用户、管理帖子、查看社区报表";
	}
}
