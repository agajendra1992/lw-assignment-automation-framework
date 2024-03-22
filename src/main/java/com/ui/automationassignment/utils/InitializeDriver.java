package com.ui.automationassignment.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitializeDriver {
	public static WebDriver driver;

	private InitializeDriver() {

	}

	public static void getDriver(BrowserType browserType) {
		if (driver == null) {	
			switch (browserType) {
			case CHROME:{
//				ChromeOptions chrome = new ChromeOptions();
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + "\\browserDriver\\chromedriver.exe");
//				chrome.setBinary(System.getProperty("user.dir") + "\\browserDriver\\chrome-win64\\chrome.exe");
//				driver = new ChromeDriver(chrome);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case CHROME_HEADLESS:{
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeheadless = new ChromeOptions();
				chromeheadless.addArguments("--headless");
				driver = new ChromeDriver(chromeheadless);
				break;
			}
			case FIREFOX:{
				WebDriverManager.firefoxdriver().setup();
				InitializeDriver.driver = new FirefoxDriver();
				break;
			}
			
			case FIREFOX_HEADLESS:{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxHeadless = new FirefoxOptions();
				firefoxHeadless.addArguments("--headless");
				InitializeDriver.driver = new FirefoxDriver(firefoxHeadless);
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unsupported browser type: " + browserType);
			}
		}
	}

}
