package Methods;

import org.openqa.selenium.By;

import utils.TestSetup;

public class Basic_methods {
	
	TestSetup testSetup;

	public Basic_methods(TestSetup testSetup) {
		this.testSetup=testSetup;
	}

	
	public void amazon_Fashion_page() {
		testSetup.driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[6]")).click();
				
		
		
	}


}
