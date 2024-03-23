package com.ui.automationassignment.pom;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ui.automationassignment.utils.Utils;
import com.ui.automationassignment.utils.Constant;
import com.ui.automationassignment.utils.InitDriver;

public class AddCartPageObjects extends Utils {

	/*
	 * AddCartPageObjects : Capture locator and actions related to add to cart page
	 * Utils class extended to make all the common method available to this class.
	 */

	private static Logger logger = LogManager.getLogger(AddCartPageObjects.class);

	private static final String OPEN_CART = "//div[@id='nav-cart-count-container']//span";
	private static final String SUBTOTAL_PRICE = "(//span[@id='sc-subtotal-amount-buybox']//span[contains(@class, 'currency')]//..)[1]";
	private static final String ADD_TO_CART = "//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']";
	private static final String DELETE_LINK = "//div[@class='sc-item-content-group']//input[@value ='Delete']";
	private static final String SKIP_WARRANTY = "//*[@id='attachSiNoCoverage']//span//input";
	private static final String CART_PAGE_PRICE = "//div[@class='sc-badge-price-to-pay']";
	private static final By OPEN_CART_XPATH = By.xpath(OPEN_CART);
	private static final By SUBTOTAL_PRICE_XPATH = By.xpath(SUBTOTAL_PRICE);
	private static final By ADD_TO_CART_XPATH = By.xpath(ADD_TO_CART);
	private static final By SKIP_WARRANTY_XPATH = By.xpath(SKIP_WARRANTY);
	private static final By DELETE_LINK_XPATH = By.xpath(DELETE_LINK);
	private static final By CART_PAGE_PRICE_XPATH = By.xpath(CART_PAGE_PRICE);

	/**
	 * This method is used for Click on AddToCart.
	 * 
	 * @param no param
	 * @return void
	 */
	public void clickAddToCart() {
		logger.debug("wait for add_to_cart element is loaded");
		waitforPageToLoad(Constant.timeout);
		waitforElementToBeVisible(ADD_TO_CART_XPATH, Constant.timeout);
		logger.debug("wait for add_to_cart element is loaded");
		javaScriptExecutorClick(ADD_TO_CART_XPATH);
		waitforPageToLoad(Constant.timeout);
		
		if (!waitforElementToBeInVisible(SKIP_WARRANTY_XPATH, Constant.polltime)) {
			clickElement(SKIP_WARRANTY_XPATH);
		} else {
			InitDriver.driver.navigate().refresh();
			waitforPageToLoad(Constant.timeout);
		}
	}

	/**
	 * This method is used for Click on Cart Icon.
	 * 
	 * @param no param
	 * @return void
	 */
	public void clickOnCart() {
		waitTime(Constant.polltime);
		waitforElementToBeClickable(OPEN_CART_XPATH, Constant.timeout);
		logger.debug("wait for open_cart element is loaded");
		javaScriptExecutorClick(OPEN_CART_XPATH);
	}

	/**
	 * This method is used for getSubTotalPrice.
	 * 
	 * @param no param
	 * @return String value
	 */

	public String getSubTotalPrice() {
		waitforElementToBeVisible(SUBTOTAL_PRICE_XPATH, Constant.timeout);
		logger.debug("wait for subtotal element is loaded");
		String subTotalPrice = getElementText(SUBTOTAL_PRICE_XPATH);
		logger.debug("subtotal price is " + subTotalPrice);
		return subTotalPrice;
	}

	/**
	 * This method is used for getCartPagePrice.
	 * 
	 * @param no param
	 * @return String value
	 */

	public String getCartPagePrice() {
		waitforElementToBeVisible(CART_PAGE_PRICE_XPATH, Constant.timeout);
		logger.debug("wait for cart page price element is loaded");
		String cartPagePrice = getElementText(CART_PAGE_PRICE_XPATH);
		logger.debug("cart page price is " + cartPagePrice);
		return cartPagePrice;
	}

	/**
	 * This method is used for getCartPagePrice.
	 * 
	 * @param no param
	 * @return cart price value list
	 */

	public List<String> getCartPriceList() {
		List<String> cartPageList = new ArrayList<String>();
		List<WebElement> element = getWeElements(CART_PAGE_PRICE_XPATH);
		logger.debug("wait for cart page price element list is loaded");
		for (WebElement ele : element) {
			cartPageList.add(ele.getText());
		}
		return cartPageList;
	}

	/**
	 * This method is used for Delete Link.
	 * 
	 * @param no param
	 * @return void
	 */

	public void clickOnDeleteLink() {
		waitforElementToBeVisible(DELETE_LINK_XPATH);
		javaScriptExecutorClick(DELETE_LINK_XPATH);
	}

}
