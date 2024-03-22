package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features", 
glue = { "stepdefinitions" }, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
        monochrome=true,
        publish = true)

public class TestNGSuiteRunner extends AbstractTestNGCucumberTests {

}
