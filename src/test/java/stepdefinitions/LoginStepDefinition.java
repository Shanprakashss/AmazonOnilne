package stepdefinitions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Methods.Basic_methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentReportManager;
import utils.Hooks;
import utils.TestSetup;

public class LoginStepDefinition {
//public WebDriver driver;
	TestSetup testSetup;

	public LoginStepDefinition(TestSetup testSetup) {
		this.testSetup = testSetup;
	}

//Hooks hooks = new Hooks();

	@Given("User Navigate to amazon homepage")
	public void User_Navigate_to_amazon_homepage() throws Throwable {
		testSetup.driver = new ChromeDriver();
		testSetup.driver.get("https://www.amazon.in/");
		testSetup.driver.manage().window().maximize();
		// ExtentReportManager.test.log(Status.INFO, "Navigated to Amazon homepage");

	}

	@When("User click on fashion and click on Mens")
	public void User_click_on_fashion_and_click_on_Mens() throws Throwable {
		testSetup.driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[7]")).click();
//	Thread.sleep(3000);
		testSetup.driver.findElement(By.xpath("//*[@id=\"sobe_d_b_1_1\"]/a/div[2]/span")).click();
		// ExtentReportManager.test.log(Status.FAIL, "Navigated to Amazon homepage");

	}

	@And("User use filter by average customer review of four stars an up")
	public void i_click_the_login_button() throws Throwable {

		testSetup.driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[12]/ul/li[1]/span/a/div")).click();

	}

	@Then("User select puma and allen solly in brands")
	public void User_select_puma_and_allen_solly_in_brands() throws Throwable {

		testSetup.driver.findElement(By.xpath("//*[@id=\"p_123/398346\"]/span/a/div/label/i")).click();

	}

	@Then("User count the number of results in first page")
	public void User_count_the_number_of_results_in_first_page() throws Throwable {

//	List<WebElement> List = testSetup.driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]"));
//	List.

		List<WebElement> searchResults = testSetup.driver.findElements(By.cssSelector(".s-main-slot .s-result-item"));

		// Print the count of search results
		System.out.println("Number of search results on the first page: " + searchResults.size());

	}

	@Then("User second product and add it to cart and User validate number on the cart is increased by one")
	public void User_second_product_and_add_it_to_cart() throws Throwable {

		testSetup.driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[1]/div/span/a/div/img"))
				.click();
		Set<String> windowHandles = testSetup.driver.getWindowHandles();

		// Switch to the new tab (assuming there are only two tabs)
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(testSetup.driver.getWindowHandle())) {
				testSetup.driver.switchTo().window(windowHandle);
				break;
			}
		}
		WebElement heading = testSetup.driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		heading.click();
		WebElement cart = testSetup.driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]"));
		String value = cart.getText();
		if (value.contains("1")) {
			System.out.println(value + "Expect cart value displayed");

		} else {
			System.out.println(value + "Expect cart value missed");

		}
		testSetup.driver.close();
		testSetup.driver.quit();

	}

}
