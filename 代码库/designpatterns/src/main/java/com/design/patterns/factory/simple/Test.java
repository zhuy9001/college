package com.design.patterns.factory.simple;

import com.design.patterns.factory.common.IProduct;
import com.design.patterns.factory.common.ProductA;
import com.design.patterns.factory.common.ProductB;

public class Test {
	
	
	public static void main(String[] args) throws Exception {
		SimpleFactory factory=new SimpleFactory();
		IProduct proA= factory.createProduct(ProductA.class);
		proA.say();
		IProduct proB= factory.createProduct(ProductB.class);
		proB.say();
	}

}
