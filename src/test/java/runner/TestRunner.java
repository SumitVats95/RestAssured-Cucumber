package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		//to pass address of feature file
		features = "src/test/resources/features/Test.feature",
		// to locate the steps definations class
		glue = {"stepDefinations"},
		plugin = { "pretty", "html:target/cucumber-reports.html" },
		//plugin = { "pretty", "json:target/cucumber-reports_JSON.json" },
		//plugin = {"pretty" ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		//it means that the console output for the Cucumber test are much more readable.
		monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests {



}
