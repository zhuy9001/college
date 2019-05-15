package com.design.patterns.factory.abstrac;

import com.design.patterns.factory.common.AbstractProductC;
import com.design.patterns.factory.common.AbstractProductD;

public abstract class AbstractProductFactory {
	
	public abstract AbstractProductC createProductC();
	
	public abstract AbstractProductD createProductD();

}
