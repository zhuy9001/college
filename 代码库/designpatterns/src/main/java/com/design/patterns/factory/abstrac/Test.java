package com.design.patterns.factory.abstrac;

import com.design.patterns.factory.common.AbstractProductC;
import com.design.patterns.factory.common.AbstractProductD;

public class Test {
	
	public static void main(String[] args) {
		Product1Factory product1Factory=new Product1Factory();
		AbstractProductC proc=product1Factory.createProductC();
		proc.say();
		AbstractProductD prod=product1Factory.createProductD();
		prod.say();
		Product2Factory product2Factory=new Product2Factory();
		proc=product2Factory.createProductC();
		proc.say();
		prod=product2Factory.createProductD();
		prod.say();
	}
	

}
