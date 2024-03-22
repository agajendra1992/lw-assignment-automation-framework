package com.ui.automationassignment.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.ProductPageObjects;

public class ProductPageAction {
	private static Logger logger = LogManager.getLogger(ProductPageAction.class);
	
	private ProductPageObjects productPageObjects = new ProductPageObjects();

	public void saveProductPrice(String productPrice) {
		productPageObjects.getPriceFromProductPage(productPrice);
	}
	
	
	
}
