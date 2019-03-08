package com.design.patterns.factory.method;

import com.design.patterns.factory.common.IProduct;

public class Test {
	public static void main(String[] args) {
		IFactory factoryA=new ProductAFactory();
		IProduct proA=factoryA.createProduct();
		proA.say();
		IFactory factoryB=new ProductBFactory();
		IProduct proB=factoryB.createProduct();
		proB.say();
	}

}
