package com.design.patterns.factory.method;

import com.design.patterns.factory.common.IProduct;
import com.design.patterns.factory.common.ProductA;

public class ProductAFactory implements IFactory {

	@Override
	public IProduct createProduct() {
		return new ProductA();
	}


}
