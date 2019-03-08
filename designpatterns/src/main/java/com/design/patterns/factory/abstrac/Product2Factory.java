package com.design.patterns.factory.abstrac;

import com.design.patterns.factory.common.AbstractProductC;
import com.design.patterns.factory.common.AbstractProductD;
import com.design.patterns.factory.common.ProductC2;
import com.design.patterns.factory.common.ProductD2;

public class Product2Factory extends AbstractProductFactory {

	@Override
	public AbstractProductC createProductC() {
		return new ProductC2();
	}

	@Override
	public AbstractProductD createProductD() {
		return new ProductD2();
	}

}
