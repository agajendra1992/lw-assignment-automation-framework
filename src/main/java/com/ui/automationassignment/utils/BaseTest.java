package com.ui.automationassignment.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Utils {
	private static Logger logger = LogManager.getLogger(BaseTest.class);
	
	
	@BeforeSuite
	public void initBrowser() {
		loadreport();
		logger.info("config is loaded");
	}
	
	@BeforeTest
	public void NavigateToApplicatioUrl() {
		String browser = properties.getProperty("browser");
		InitDriver.getDriver(BrowserType.fromString(browser));
		logger.info(browser+ " browser is launched successfully");
		InitDriver.driver.manage().window().maximize();
		logger.info("browser is maximized");
		InitDriver.driver.get(properties.getProperty("url"));
		logger.info("url "+ properties.getProperty("url") +" is launched");
	}
	
	@AfterSuite
	public void teardown() {
		try {
			tearbrowser();
			logger.info("cleaning up browser session");
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}

	}

}
