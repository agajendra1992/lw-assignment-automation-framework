package com.ui.automationassignment.validations;

import static org.testng.Assert.assertTrue;

import com.ui.automationassignment.pom.HomePageObjects;

public class HomePageValidation {
	private HomePageObjects homePageObjects = new HomePageObjects();
	
	public void validateProductsListIsDiplayed() {
		assertTrue(homePageObjects.getSearchItemList()>0, "Product Items List is not displayed");
	
	}
	
	public void HomePageIsDisplayed() {
		assertTrue(homePageObjects.ClickOnAmazonIcon(), "Home Page is not displayed");
	
	}



}
