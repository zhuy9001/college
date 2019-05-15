package com.design.patterns.factory.method;

import com.design.patterns.factory.common.IProduct;
import com.design.patterns.factory.common.ProductB;

public class ProductBFactory implements IFactory {

	@Override
	public IProduct createProduct() {
		return new ProductB();
	}

}
