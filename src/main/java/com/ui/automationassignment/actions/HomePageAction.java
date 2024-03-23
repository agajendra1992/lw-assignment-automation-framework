package com.ui.automationassignment.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.HomePageObjects;

public class HomePageAction {
	
	/*
	 * HomePageAction : This class we have kept each actions captured in the
	 * HomePageObjects and related to all the HomePageAction performed.
	 */
	private static Logger logger = LogManager.getLogger(HomePageAction.class);
	
	private HomePageObjects homePageObjects = new HomePageObjects();

	public void setProductInSearchBoxAndClicked(String product) {
		homePageObjects.setProduct(product);
		logger.info("product is set search bar");
		homePageObjects.clickSearchIcon();
		logger.info("clicked on search icon");
	}
	
	
	public void clickOnSearchedProduct(int product) {
		logger.info("select the  searched product");
		homePageObjects.selectSearchedProducts(product);
	}
	
	public void navigateToHomePage() {
		homePageObjects.ClickOnAmazonIcon();
		logger.info("navigate to home page");		
	}

}
