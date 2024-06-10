package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = {"stepdefinitions"},
		monochrome = true,
		plugin = {"pretty",
		        "html:target/cucumberReports.html",
		             })
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
	

}
