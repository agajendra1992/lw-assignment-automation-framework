package com.ui.automationassignment.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.ui.automationassignment.pom.AddCartPageObjects;
import com.ui.automationassignment.utils.InitDriver;

public class AddCartPageAction {
	
	/*
	 * AddCartPageAction : This class we have kept each actions captured in the
	 * AddCartPageObjects and related to all the AddCartActions performed.
	 */
	 
	private static Logger logger = LogManager.getLogger(AddCartPageAction.class);
	
	private AddCartPageObjects addCartPageObjects = new AddCartPageObjects();

	public void clickOnAddToCart() {
		addCartPageObjects.clickAddToCart();
		logger.info("AddToCart button is clicked");
	}

	public void NavigateToOpenCart() {
		addCartPageObjects.clickOnCart();
		logger.info("Cart button is clicked");
	}

	public void clickOnDeleteProduct() {
		logger.info("Delete link is clicked");
		addCartPageObjects.clickOnDeleteLink();
	}
}
