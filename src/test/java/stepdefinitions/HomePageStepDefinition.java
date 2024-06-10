package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.TestSetup;

public class HomePageStepDefinition {
	TestSetup testSetup;

	public HomePageStepDefinition(TestSetup testSetup) {
		this.testSetup=testSetup;
	}
	
	@Then("^I am on My account home page$")
    public void i_am_on_my_account_home_page() throws Throwable {
		Thread.sleep(5000);
		String home = testSetup.driver.findElement(By.xpath("//div[text()='My Account']")).getText();
		Assert.assertEquals(home, "My Account");
    }
	
	@And("^Logout the application$")
    public void logout_the_application() throws Throwable {
		WebElement myAcc = testSetup.driver.findElement(By.xpath("//div[text()='My Account']"));
		Actions ac = new Actions(testSetup.driver);
		ac.moveToElement(myAcc).perform();
		testSetup.driver.findElement(By.xpath("//*[text()='Logout']")).click();
    }
}
