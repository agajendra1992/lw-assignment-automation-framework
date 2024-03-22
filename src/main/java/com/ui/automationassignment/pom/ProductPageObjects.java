package com.ui.automationassignment.pom;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.ui.automationassignment.utils.Utils;
import com.ui.automationassignment.utils.Constant;
import com.ui.automationassignment.utils.InitializeDriver;

public class ProductPageObjects extends Utils {
	private static Logger logger = LogManager.getLogger(ProductPageObjects.class);
	
	private static final String ADD_TO_CART = "//input[@id='add-to-cart-button']";
	private static final String CART_PRODUCT_PAGE = "//span[@id='attach-sidesheet-view-cart-button']";
	private static final String PRODUCT_PAGE_LIST = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
	private static final By PRODUCT_PAGE_XPATH = By.xpath(PRODUCT_PAGE_LIST);
	private static final String PRODUCT_PAGE_PRICE = "//div//div[starts-with(@id , 'corePriceDisplay_')]//span[@class='a-price-whole']";
	private static final By PRODUCT_PAGE_PRICE_XPATH = By.xpath(PRODUCT_PAGE_PRICE);

	public boolean productPageIsDisplayed() {
		boolean productPage = InitializeDriver.driver.getCurrentUrl().contains("Monitor");
		return productPage;
	}

	public void getPriceFromProductPage(String productPrice) {
		switchToWindowTab();
		waitforElementToBePresent(PRODUCT_PAGE_PRICE_XPATH, Constant.timeout);
		Constant.savedValues.put(productPrice, getElementText(PRODUCT_PAGE_PRICE_XPATH));
	}
}
