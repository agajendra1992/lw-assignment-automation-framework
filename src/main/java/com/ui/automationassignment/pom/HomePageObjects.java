package com.ui.automationassignment.pom;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ui.automationassignment.utils.Utils;
import com.ui.automationassignment.utils.Constant;

public class HomePageObjects extends Utils {
	
	/*
	 * HomePageObjects : Capture locators and actions related to home page
	 * Utils class extended to make all the common method available to this class.
	 */ 
	private static Logger logger = LogManager.getLogger(HomePageObjects.class);
	
	private static final String SEARCH_BOX = "//input[@id='twotabsearchtextbox']";
	private static final String ITEM_ORDER = "(//a//span[@class='a-size-medium a-color-base a-text-normal'])[%s]";
	private static final String SEARCH_ICON = "//input[@value='Go']";
	private static final String SEARCHED_ITEM_LIST = "//div[@*='s-search-result']";
	private static final String AMAZON_ICON = "//a[@*='Amazon.in']";

	private static final By SEARCH_BOX_XPATH = By.xpath(SEARCH_BOX);
	private static final By SEARCH_ICON_XPATH = By.xpath(SEARCH_ICON);
	private static final By SEARCHED_ITEM_LIST_XPATH = By.xpath(SEARCHED_ITEM_LIST);
	private static final By AMAZON_ICON_XPATH = By.xpath(AMAZON_ICON);

	/**
	 * This method is used for Set the text in search bar.
	 * 
	 * @param String product
	 * @return  void
	 */
	public void setProduct(String product) {
		waitforElementToBeVisible(SEARCH_BOX_XPATH, Constant.timeout);
		logger.info("searchbox element is visible");
		clearElement(SEARCH_BOX_XPATH);
		logger.info("searchbox element is cleared");
		setElement(SEARCH_BOX_XPATH, product);
	}

	/**
	 * This method is used for click on SearchIcon.
	 * 
	 * @param no param
	 * @return  void
	 */
	public void clickSearchIcon() {
		logger.info("search icon element is clickable");
		waitforElementToBeClickable(SEARCH_ICON_XPATH);
		clickElement(SEARCH_ICON_XPATH);
	}
	
	/**
	 * This method is used for geSerachItemList
	 * 
	 * @param no param
	 * @return  return integer value
	 */

	public int getSearchItemList() {
		List<WebElement> itemList = getWeElements(SEARCHED_ITEM_LIST_XPATH);
		logger.info("searched item elementlist is displayed as "+ itemList.size());
		return itemList.size();
	}
	
	/**
	 * This method is used for geSerachItemList
	 * 
	 * @param int orderItem
	 * @return void
	 */

	public void selectSearchedProducts(int orderItem) {
		By ITEM_ORDER_XPATH = By.xpath(String.format(ITEM_ORDER, orderItem));
		WebElement product = getWeElement(ITEM_ORDER_XPATH);
		logger.info("item element is visible");
		waitforElementToBeVisible(ITEM_ORDER_XPATH, Constant.timeout);
		moveToElement(product);
		logger.info("item element is clickable");
		waitforElementToBeClickable(ITEM_ORDER_XPATH);
		clickElement(ITEM_ORDER_XPATH);
	}
	
	/**
	 * This method is used for Click on home page amazon icon
	 * 
	 * @param no param
	 * @return boolean value as true or false
	 */
	public boolean ClickOnAmazonIcon() {
		logger.info("amazon icon element is clickable");
		waitforElementToBeClickable(AMAZON_ICON_XPATH);
		clickElement(AMAZON_ICON_XPATH);
		waitforElementToBeVisible(SEARCH_BOX_XPATH, Constant.timeout);
		return getWeElement(SEARCH_ICON_XPATH).isDisplayed();
	}

}
