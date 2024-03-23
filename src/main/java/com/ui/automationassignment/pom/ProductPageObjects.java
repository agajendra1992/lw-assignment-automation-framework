package com.ui.automationassignment.pom;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.ui.automationassignment.utils.Utils;
import com.ui.automationassignment.utils.Constant;
import com.ui.automationassignment.utils.InitDriver;

public class ProductPageObjects extends Utils {
	
	/*
	 * ProductPageObjects : Capture locators and actions related to product page
	 * Utils class extended to make all the common method available to this class.
	 */ 
	
	private static Logger logger = LogManager.getLogger(ProductPageObjects.class);
	
	private static final String PRODUCT_PAGE_PRICE = "//div//div[starts-with(@id , 'corePriceDisplay_')]//span[@class='a-price-whole']";
	private static final By PRODUCT_PAGE_PRICE_XPATH = By.xpath(PRODUCT_PAGE_PRICE);

	/**
	 * This method is used for get productPageIsDisplayen
	 * 
	 * @param String product
	 * @return boolean value as true or false
	 */
	public boolean productPageIsDisplayed(String product ) {
		boolean productPage = InitDriver.driver.getCurrentUrl().contains(product);
		return productPage;
	}
	
	/**
	 * This method is used for get product price
	 * 
	 * @param Strin product price
	 * @return void
	 */

	public void getPriceFromProductPage(String productPrice) {
		switchToWindowTab();
		logger.info("focus moved to child window");
		waitforElementToBePresent(PRODUCT_PAGE_PRICE_XPATH, Constant.timeout);
		logger.info("product price elemt is present");
		Constant.savedValues.put(productPrice, getElementText(PRODUCT_PAGE_PRICE_XPATH));
		logger.info("save the product price as "+ getElementText(PRODUCT_PAGE_PRICE_XPATH));
	}
}
