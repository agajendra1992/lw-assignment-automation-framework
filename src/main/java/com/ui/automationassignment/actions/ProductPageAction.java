package com.ui.automationassignment.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.ProductPageObjects;

public class ProductPageAction {
	
	/*
	 * ProductPageAction : This class we have kept each actions captured in the
	 * ProductPageObjects and related to all the ProductPageAction performed.
	 */
	private static Logger logger = LogManager.getLogger(ProductPageAction.class);
	
	private ProductPageObjects productPageObjects = new ProductPageObjects();

	public void saveProductPrice(String productPrice) {
		logger.info("amazon icon element is clickable");
		productPageObjects.getPriceFromProductPage(productPrice);
	}
	
	
	
}
