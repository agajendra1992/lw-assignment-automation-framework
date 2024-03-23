package com.ui.automationassignment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	
	/*
	 * This class is created to capture all common methods for performing actions.
	 * Note: Currently, only a few methods are implemented, but more generic methods can be added.
	 */

	private File file;
	private FileInputStream fileInputStream;
	private static Logger logger = LogManager.getLogger(Utils.class);
	protected Properties properties = new Properties();

	
	/**
	 * This method is used for move action.
	 * 
	 * @param no parameter
	 * @return  Actions
	 */
	private Actions moveAction() {
		Actions action = new Actions(InitDriver.driver);
		return action;
	}
	
	/**
	 * This method is used for click element using By locator.
	 * 
	 * @param By locator
	 * @return  void
	 */

	public void clickElement(By locator) {
		InitDriver.driver.findElement(locator).click();
	}
	
	/**
	 * This method is used for click submit using By locator.
	 * 
	 * @param By locator
	 * @return  void
	 */


	public void clickSubmit(By locator) {
		InitDriver.driver.findElement(locator).submit();
	}
	
	/**
	 * This method is used for clear element using By locator.
	 * 
	 * @param By locator
	 * @return  void
	 */


	public void clearElement(By locator) {
		InitDriver.driver.findElement(locator).clear();
	}

	/**
	 * This method is used for set text element using By locator.
	 * 
	 * @param By locator, String text
	 * @return  void
	 */

	public void setElement(By locator, String text) {
		InitDriver.driver.findElement(locator).sendKeys(text);
	}
	
	/**
	 * This method is used for move to element.
	 * 
	 * @param WeElement ele
	 * @return  void
	 */

	public void moveToElement(WebElement ele) {
		moveAction().moveToElement(ele).build().perform();
	}
	
	
	/**
	 * This method is used for create select class object.
	 * 
	 * @param WeElement ele
	 * @return  select
	 */


	private Select select(WebElement element) {
		Select select = new Select(element);
		return select;
	}
	
	/**
	 * This method is used for select by visibletext.
	 * 
	 * @param WeElement ele, String value
	 * @return  void
	 */


	public void selectDropdown(WebElement element, String value) {
		select(element).selectByVisibleText(value);
	}
	
	/**
	 * This method is used for selectByIndex.
	 * 
	 * @param WeElement ele, int index
	 * @return  void
	 */

	public void selectDropdown(WebElement element, int index) {
		select(element).selectByIndex(index);
	}
	
	
	/**
	 * This method is used for select by waitforPageToLoad.
	 * 
	 * @param no params
	 * @return  void
	 */

//	public void waitforPageToLoad() {
//		InitDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
	
	public void waitForPageToLoad(int timeoutInSeconds) {
       WebDriverWait wait = new WebDriverWait(InitDriver.driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }
	

	/**
	 * This method is used for waitforPageToLoad.
	 * 
	 * @param int time
	 * @return  void
	 */

	public void waitforPageToLoad(int time) {
		InitDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	

	/**
	 * This method is used for waitTime.
	 * 
	 * @param int time
	 * @return  void
	 */
	
	public void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method is used for waitElement.
	 * 
	 * @param By Locator, int time
	 * @return  WebDriverwait
	 */

	private WebDriverWait waitElement(By locator, int time) {
		WebDriverWait webDriverWait = new WebDriverWait(InitDriver.driver, Duration.ofSeconds(time));
		return webDriverWait;
	}
	
	/**
	 * This method is used for waitElement.
	 * 
	 * @param By Locator, int time, int polltime
	 * @return  WebDriverwait
	 */

	private WebDriverWait waitElementWithPolling(By locator, int timeout, int polltime) {
		WebDriverWait webDriverWait = new WebDriverWait(InitDriver.driver, Duration.ofSeconds(timeout));
		webDriverWait.pollingEvery(Duration.ofSeconds(polltime));
		return webDriverWait;
	}
	
	/**
	 * This method is used for waitforElementToBeVisible.
	 * 
	 * @param By Locator
	 * @return  void
	 */

	public void waitforElementToBeVisible(WebElement ele, int timeout) {
		WebDriverWait wait =  new WebDriverWait(InitDriver.driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	/**
	 * This method is used for waitforElementToBeVisible.
	 * 
	 * @param By Locator
	 * @return  void
	 */

	public void waitforElementToBeVisible(By locator) {
		waitElement(locator, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * This method is used for getElementText.
	 * 
	 * @param By Locator
	 * @return  String
	 */

	public String getElementText(By locator) {
		WebElement textElement = InitDriver.driver.findElement(locator);
		return textElement.getText();
	}
	
	/**
	 * This method is used for waitforElementToBeVisible.
	 * 
	 * @param By Locator, int time
	 * @return  void
	 */

	public void waitforElementToBeVisible(By locator, int time) {
		waitElement(locator, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * This method is used for waitforElementToBePresent.
	 * 
	 * @param By Locator, int time
	 * @return  void
	 */

	public void waitforElementToBePresent(By locator, int time) {
		waitElement(locator, time).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * This method is used for waitforElementToBeVisibleWithPolling.
	 * 
	 * @param By Locator, int time, int polltime
	 * @return  boolean
	 */

	public boolean waitforElementToBeVisibleWithPolling(By locator, int timeout, int polltime) {
		return waitElementWithPolling(locator, timeout, polltime)
				.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}
	
	/**
	 * This method is used for waitforElementToBeInVisible.
	 * 
	 * @param By Locator, int time
	 * @return  boolean
	 */

	public boolean waitforElementToBeInVisible(By locator, int timeout) {
		return waitElementWithPolling(locator, timeout, Constant.polltime)
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	/**
	 * This method is used for waitforElementToBeClickable.
	 * 
	 * @param By Locator
	 * @return  void
	 */
	public void waitforElementToBeClickable(By locator) {
		waitElement(locator, 10).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * This method is used for waitforElementToBeClickable.
	 * 
	 * @param By Locator, int time
	 * @return  void
	 */

	public void waitforElementToBeClickable(By locator, int time) {
		waitElement(locator, time).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * This method is used for getWebElement.
	 * 
	 * @param By Locator
	 * @return  WebElement
	 */

	public WebElement getWeElement(By locator) {
		return InitDriver.driver.findElement(locator);
	}
	
	/**
	 * This method is used for get of WebElements.
	 * 
	 * @param By Locator
	 * @return  List of WebElement
	 */

	public List<WebElement> getWeElements(By locator) {
		return InitDriver.driver.findElements(locator);
	}
	
	/**
	 * This method is used for getWindowHandle.
	 * 
	 * @param no param
	 * @return  String windowId
	 */

	private String getWindowHandle() {
		return InitDriver.driver.getWindowHandle();
	}
	
	/**
	 * This method is used for getWindowHandles.
	 * 
	 * @param no param
	 * @return  Set of String windowId
	 */

	public Set<String> getWindowHandles() {
		return InitDriver.driver.getWindowHandles();
	}
	
	/**
	 * This method is used for swictToChildWindow.
	 * 
	 * @param no param
	 * @return  void
	 */

	public void switchToWindowTab() {
		String parent = getWindowHandle();
		Set<String> windowHandles = InitDriver.driver.getWindowHandles();
		for (String window : windowHandles) {
			if (!window.equals(parent)) {
				InitDriver.driver.switchTo().window(window);
			}

		}
	}
	
	/**
	 * This method is used for closeCurrentTab.
	 * 
	 * @param no param
	 * @return  void
	 */
	public void closeTab() {
		Set<String> windowHandles = InitDriver.driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		if (iterator.hasNext()) {
			String firstWindowHandle = iterator.next();
			InitDriver.driver.switchTo().window(firstWindowHandle).close();
		}
	}

	public void switchToParentWindow() {
		InitDriver.driver.switchTo().defaultContent();
	}

	
	/**
	 * This method is used for clickOn Element using JavaScriptExecutor.
	 * 
	 * @param By Locator
	 * @return  void
	 */
	public void javaScriptExecutorClick(By locator) {
		WebElement element = InitDriver.driver.findElement(locator);
		JavascriptExecutor jse = ((JavascriptExecutor) InitDriver.driver);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

	}
	
	/**
	 * This method is used for clickOn Element using JavaScriptExecutor.
	 * 
	 * @param By Locator
	 * @return  void
	 */
	public void javaScriptExecutorClickView(By locator) {
		WebElement element = InitDriver.driver.findElement(locator);
		JavascriptExecutor jse = ((JavascriptExecutor) InitDriver.driver);
		jse.executeScript("arguments[0].scrollIntoView(false);", element);
		element.click();

	}
	
	/**
	 * This method is used for close tab using JavaScriptExecutor.
	 * 
	 * @param no param
	 * @return  void
	 */

	public void javaScriptExecutorCloseTab() {
		JavascriptExecutor jse = ((JavascriptExecutor) InitDriver.driver);
		jse.executeScript("window.close()");

	}

	/**
	 * This method is used for close tab using kill browser processid.
	 * 
	 * @param no param
	 * @return  void
	 */
	private void killbrowserprocess() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /im chromedriver.exe /f");
			runtime.exec("taskkill /im geckodriver.exe /f");
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method is used for close tab using close all the browser.
	 * 
	 * @param no param
	 * @return  void
	 */
	protected void tearbrowser() {
		try {
			InitDriver.driver.close();
			InitDriver.driver.quit();

		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			killbrowserprocess();
		}
	}
	/**
	 * This method is used for load config properties.
	 * 
	 * @param no param
	 * @return  void
	 */
	protected void loadreport() {
		loadproperties();
	}

	/**
	 * This method is used for load log4j properties.
	 * 
	 * @param no param
	 * @return  void
	 */
	private void loadproperties() {
		try {
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			file = new File(System.getProperty("user.dir") + "\\config.properties");
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (IOException e) {
			Thread.currentThread().interrupt();
		}
	}

}
