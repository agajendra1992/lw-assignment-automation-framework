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

	private File file;
	private FileInputStream fileInputStream;
	private static Logger logger = LogManager.getLogger(Utils.class);
	protected Properties properties = new Properties();

	private Actions moveAction() {
		Actions action = new Actions(InitializeDriver.driver);
		return action;
	}

	public void clickElement(By locator) {
		InitializeDriver.driver.findElement(locator).click();
	}

	public void clickSubmit(By locator) {
		InitializeDriver.driver.findElement(locator).submit();
	}

	public void clearElement(By locator) {
		InitializeDriver.driver.findElement(locator).clear();
	}

	public void setElement(By locator, String text) {
		InitializeDriver.driver.findElement(locator).sendKeys(text);
	}

	public void moveToElement(WebElement ele) {
		moveAction().moveToElement(ele).build().perform();
	}

	private Select select(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public void selectDropdown(WebElement element, String value) {
		select(element).selectByVisibleText(value);
	}

	public void selectDropdown(WebElement element, int index) {
		select(element).selectByIndex(index);
	}

	public void waitforPageToLoad() {
		InitializeDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitforPageToLoad(int time) {
		InitializeDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	private WebDriverWait waitElement(By locator, int time) {
		WebDriverWait webDriverWait = new WebDriverWait(InitializeDriver.driver, Duration.ofSeconds(time));
		return webDriverWait;
	}

	private WebDriverWait waitElementWithPolling(By locator, int timeout, int polltime) {
		WebDriverWait webDriverWait = new WebDriverWait(InitializeDriver.driver, Duration.ofSeconds(timeout));
		webDriverWait.pollingEvery(Duration.ofSeconds(polltime));
		return webDriverWait;
	}

	public void waitforElementToBeVisible(By locator) {
		waitElement(locator, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String getElementText(By locator) {
		WebElement textElement = InitializeDriver.driver.findElement(locator);
		return textElement.getText();
	}

	public void waitforElementToBeVisible(By locator, int time) {
		waitElement(locator, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitforElementToBePresent(By locator, int time) {
		waitElement(locator, time).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean waitforElementToBeVisibleWithPolling(By locator, int timeout, int polltime) {
		return waitElementWithPolling(locator, timeout, polltime)
				.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}

	public boolean waitforElementToBeInVisible(By locator, int timeout) {
		return waitElement(locator, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitforElementToBeClickable(By locator) {
		waitElement(locator, 10).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitforElementToBeClickable(By locator, int time) {
		waitElement(locator, time).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement getWeElement(By locator) {
		return InitializeDriver.driver.findElement(locator);
	}

	public List<WebElement> getWeElements(By locator) {
		return InitializeDriver.driver.findElements(locator);
	}

	private String getWindowHandle() {
		return InitializeDriver.driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return InitializeDriver.driver.getWindowHandles();
	}

	public void switchToWindowTab() {
		String parent = getWindowHandle();
		Set<String> windowHandles = InitializeDriver.driver.getWindowHandles();
		for (String window : windowHandles) {
			if (!window.equals(parent)) {
				InitializeDriver.driver.switchTo().window(window);
			}

		}
	}

	public void closeTab() {
		Set<String> windowHandles = InitializeDriver.driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		if (iterator.hasNext()) {
			String firstWindowHandle = iterator.next();
			InitializeDriver.driver.switchTo().window(firstWindowHandle).close();
			;
		}
	}

	public void switchToParentWindow() {
		InitializeDriver.driver.switchTo().defaultContent();
	}

	public void javaScriptExecutorClick(By locator) {
		WebElement element = InitializeDriver.driver.findElement(locator);
		JavascriptExecutor jse = ((JavascriptExecutor) InitializeDriver.driver);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

	}

	public void javaScriptExecutorCloseTab() {
		JavascriptExecutor jse = ((JavascriptExecutor) InitializeDriver.driver);
		jse.executeScript("window.close()");

	}

	private void killbrowserprocess() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /im chromedriver.exe /f");
			runtime.exec("taskkill /im geckodriver.exe /f");
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

	protected void tearbrowser() {
		try {
			InitializeDriver.driver.close();
			InitializeDriver.driver.quit();

		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			killbrowserprocess();
		}
	}

	protected void loadreport() {
		loadproperties();
	}

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
