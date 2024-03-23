package com.ui.automationassignment.validations;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.HomePageObjects;

public class HomePageValidation {
	private static Logger logger = LogManager.getLogger(HomePageValidation.class);
	private HomePageObjects homePageObjects = new HomePageObjects();


	public void validateProductsListIsDiplayed() {
		assertTrue(homePageObjects.getSearchItemList()>0, "Product Items List is not displayed");
		logger.info("product item is displayed as " + homePageObjects.getSearchItemList());
	}
	
	public void HomePageIsDisplayed() {
		assertTrue(homePageObjects.ClickOnAmazonIcon(), "Home Page is not displayed");
		logger.info("home page is displayed");	
	}



}
