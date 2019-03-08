package com.design.patterns.factory.abstrac;

import com.design.patterns.factory.common.AbstractProductC;
import com.design.patterns.factory.common.AbstractProductD;
import com.design.patterns.factory.common.ProductC1;
import com.design.patterns.factory.common.ProductD1;

public class Product1Factory extends AbstractProductFactory {

	@Override
	public AbstractProductC createProductC() {
		
		return new ProductC1();
	}

	@Override
	public AbstractProductD createProductD() {
		// TODO Auto-generated method stub
		return new ProductD1();
	}

}
