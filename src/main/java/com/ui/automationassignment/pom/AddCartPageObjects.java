package com.ui.automationassignment.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ui.automationassignment.utils.Utils;
import com.ui.automationassignment.utils.Constant;
import com.ui.automationassignment.utils.InitializeDriver;

public class AddCartPageObjects extends Utils {

	private static final String OPEN_CART = "//div[@id='nav-cart-count-container']//span";
	private static final String SUBTOTAL_PRICE = "(//span[@id='sc-subtotal-amount-buybox']//span[contains(@class, 'currency')]//..)[1]";
	private static final String CART_PRODUCT_PAGE = "//span[@id='attach-sidesheet-view-cart-button']";
	private static final String ADD_TO_CART = "//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']";
	private static final String DELETE_LINK = "//div[@class='sc-item-content-group']//input[@value ='Delete']";
	private static final String SKIP_WARRANTY = "//*[@id='attachSiNoCoverage']/span/input";
	private static final String CART_PAGE_PRICE = "//div[@class='sc-badge-price-to-pay']";
	private static final String ADDED_TO_CART = "//div[@id='attachDisplayAddBaseAlert']//h4[text()='Added to Cart']";
	
	private static final By OPEN_CART_XPATH = By.xpath(OPEN_CART);
	private static final By SUBTOTAL_PRICE_XPATH = By.xpath(SUBTOTAL_PRICE);
	private static final By CART_PRODUCT_PAGE_XPATH = By.xpath(CART_PRODUCT_PAGE);
	private static final By ADD_TO_CART_XPATH = By.xpath(ADD_TO_CART);
	private static final By SKIP_WARRANTY_XPATH = By.xpath(SKIP_WARRANTY);
	private static final By DELETE_LINK_XPATH = By.xpath(DELETE_LINK);
	private static final By CART_PAGE_PRICE_XPATH = By.xpath(CART_PAGE_PRICE);
	private static final By ADDED_TO_CART_XPATH = By.xpath(ADDED_TO_CART);

	public void clickAddToCart() {
		waitforPageToLoad();
		waitforElementToBeVisible(ADD_TO_CART_XPATH, Constant.timeout);
		clickElement(ADD_TO_CART_XPATH);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		if (!waitforElementToBeInVisible(SKIP_WARRANTY_XPATH, Constant.timeout)) {
			waitforElementToBeVisible(SKIP_WARRANTY_XPATH, Constant.timeout);
			clickElement(SKIP_WARRANTY_XPATH);
		}

		else {
			waitforPageToLoad();
			InitializeDriver.driver.navigate().refresh();
			;
		}
	}

	public void clickOnCart() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		}
		waitforElementToBeClickable(OPEN_CART_XPATH, Constant.timeout);
		javaScriptExecutorClick(OPEN_CART_XPATH);

	}

	public String getSubTotalPrice() {
		waitforElementToBeVisible(SUBTOTAL_PRICE_XPATH, Constant.timeout);
		String subTotalPrice = getElementText(SUBTOTAL_PRICE_XPATH);
		return subTotalPrice;
	}

	public String getCartPagePrice() {
		waitforElementToBeVisible(CART_PAGE_PRICE_XPATH, Constant.timeout);
		String cartPagePrice = getElementText(CART_PAGE_PRICE_XPATH);
		return cartPagePrice;
	}

	public List<String> getCartPriceList() {
		List<String> cartPageList = new ArrayList<String>();
		List<WebElement> element = getWeElements(CART_PAGE_PRICE_XPATH);
		for (WebElement ele : element) {
			cartPageList.add(ele.getText());
		}
		return cartPageList;
	}

	public void clickOnDeleteLink() {
		waitforElementToBeVisible(DELETE_LINK_XPATH);
		javaScriptExecutorClick(DELETE_LINK_XPATH);
	}

}
