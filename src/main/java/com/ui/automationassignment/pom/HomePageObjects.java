package com.ui.automationassignment.pom;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ui.automationassignment.utils.Utils;
import com.ui.automationassignment.utils.Constant;

public class HomePageObjects extends Utils {
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

	public void setProduct(String product) {
		waitforElementToBeVisible(SEARCH_BOX_XPATH, Constant.timeout);
		clearElement(SEARCH_BOX_XPATH);
		setElement(SEARCH_BOX_XPATH, product);
	}

	public void clickSearchIcon() {
		waitforElementToBeClickable(SEARCH_ICON_XPATH);
		clickElement(SEARCH_ICON_XPATH);
	}

	public int getSearchItemList() {
		List<WebElement> itemList = getWeElements(SEARCHED_ITEM_LIST_XPATH);
		return itemList.size();
	}

	public void selectSearchedProducts(int orderItem) {
		By ITEM_ORDER_XPATH = By.xpath(String.format(ITEM_ORDER, orderItem));
		WebElement product = getWeElement(ITEM_ORDER_XPATH);
		waitforElementToBeVisible(ITEM_ORDER_XPATH, Constant.timeout);
		moveToElement(product);
		waitforElementToBeClickable(ITEM_ORDER_XPATH);
		clickElement(ITEM_ORDER_XPATH);
	}
	
	public boolean ClickOnAmazonIcon() {
		waitforElementToBeClickable(AMAZON_ICON_XPATH);
		clickElement(AMAZON_ICON_XPATH);
		waitforElementToBeVisible(SEARCH_BOX_XPATH, Constant.timeout);
		return getWeElement(SEARCH_ICON_XPATH).isDisplayed();
	}

}
