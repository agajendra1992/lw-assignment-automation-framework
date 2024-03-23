package com.ui.automationassignment.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitDriver {
	public static WebDriver driver;

	private InitDriver() {

	}
	/**
	 * This method is used for launch the browser .
	 * 
	 * @param BrowserType as "Chrome"
	 * @return  static void
	 */
	public static void getDriver(BrowserType browserType) {
		if (driver == null) {
			switch (browserType) {
			case CHROME: {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case CHROME_HEADLESS: {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeheadless = new ChromeOptions();
				chromeheadless.addArguments("--headless");
				driver = new ChromeDriver(chromeheadless);
				break;
			}
			case FIREFOX: {
				WebDriverManager.firefoxdriver().setup();
				InitDriver.driver = new FirefoxDriver();
				break;
			}
			case FIREFOX_HEADLESS: {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxHeadless = new FirefoxOptions();
				firefoxHeadless.addArguments("--headless");
				InitDriver.driver = new FirefoxDriver(firefoxHeadless);
				break;
			}
			default:
				throw new IllegalArgumentException("Unsupported browser type: " + browserType);
			}
		}
	}

}
