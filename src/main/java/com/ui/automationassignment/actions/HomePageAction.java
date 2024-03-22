package com.ui.automationassignment.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.HomePageObjects;

public class HomePageAction {
	private static Logger logger = LogManager.getLogger(AddCartPageAction.class);
	private HomePageObjects homePageObjects = new HomePageObjects();

	public void setProductInSearchBoxAndClicked(String product) {
		homePageObjects.setProduct(product);
		homePageObjects.clickSearchIcon();
	}
	
	
	public void clickOnSearchedProduct(int product) {
		
		homePageObjects.selectSearchedProducts(product);
	}
	
	public void navigateToHomePage() {
		homePageObjects.ClickOnAmazonIcon();
		
	}

}
