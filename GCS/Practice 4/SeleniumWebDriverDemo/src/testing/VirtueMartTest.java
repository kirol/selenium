/**
 * @author Thanh Tran
 *
 */

package testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class VirtueMartTest {
	WebDriver driver;
	WebDriverWait _wait;
  @Test
  public void happyPathTest() {
	  driver.get("http://tranminhthanh.info/training/selenium/VirtualMart/");	
	  //TODO: Continue your test case developing here
	  
	  
  }

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "browserDrivers/Chrome/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}
