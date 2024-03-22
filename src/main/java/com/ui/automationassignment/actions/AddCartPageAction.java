package com.ui.automationassignment.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.AddCartPageObjects;
import com.ui.automationassignment.utils.InitializeDriver;
import com.ui.automationassignment.validations.HomePageValidation;

public class AddCartPageAction {
	private static Logger logger = LogManager.getLogger(AddCartPageAction.class);
	
	private AddCartPageObjects addCartPageObjects = new AddCartPageObjects();

	public void clickOnAddToCart() {
		addCartPageObjects.clickAddToCart();
	}

	public void NavigateToOpenCart() {
		addCartPageObjects.clickOnCart();
	}

	public void clickOnDeleteProduct() {
		addCartPageObjects.clickOnDeleteLink();
	}
}
