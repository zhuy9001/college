package com.design.patterns.decorator;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname BarDecorate
 * @PackageName com.design.patterns.decorator
 * @Date 2020/3/5 14:08
 */
public class BarDecorate extends  Bar {

	private Bar bar;

	public BarDecorate(Bar bar) {
		this.bar=bar;
	}

	@Override
   public String getBar() {
		return bar.getBar();
	}
}
