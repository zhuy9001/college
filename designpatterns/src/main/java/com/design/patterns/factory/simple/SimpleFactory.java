package com.design.patterns.factory.simple;

import com.design.patterns.factory.common.IProduct;

public class SimpleFactory {

	public IProduct createProduct(Class<?> clazz) throws Exception {
		IProduct pro = null;

		if (clazz != null) {
			boolean flag = IProduct.class.isAssignableFrom(clazz);
			if(flag) {
				pro = (IProduct) clazz.newInstance();
			}else {
				throw new Exception("不是指定接口产品，不能创建。");
			}
			
		}

		return pro;

	}

}
