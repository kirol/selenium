/**
 * @author Thanh Tran
 *
 */

package testing;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VirtueMartTest {
	WebDriver driver;
	Properties prop = new Properties();
	
	
	
	
  @Test
  public void happyPathTest() {
	  
	  File file = new File("TestData/datafile.properties");
	  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
	  driver.get("http://tranminhthanh.info/training/selenium/VirtualMart/");	
	  //TODO: Continue your test case developing here
	  
	  ifindElement("headpiece").click();
	  
	  
	  ifindElement("cowboyhat_details").click();
	  
	  WebElement webElement1 = ifindElement("cowboyhat_size_select");
	  Actions actions = new Actions(driver);
	  actions.moveToElement(webElement1);
	  actions.click();
	  actions.sendKeys("Size: XL");
	  actions.sendKeys(Keys.ENTER);
	  actions.build().perform();
	  
	  WebElement webElement2 = driver.findElement(By.xpath(prop.getProperty("cowboyhat_quantity")));
	  webElement2.click();
	  webElement2.sendKeys(Keys.CONTROL,"a");
	  webElement2.sendKeys("3");
	  actions.build().perform();
	  
	  ifindElement("cowboyhat_addtocart").click();
	  
	  ifindElement("home").click();
	  
	  ifindElement("wear").click();
	  
	  ifindElement("zipperpullover_details").click();
	  
	  WebElement webElement3 = ifindElement("zipperpullover_custom1");
	  actions.moveToElement(webElement3);
	  actions.click();
	  actions.sendKeys("Handmade");
	  actions.sendKeys(Keys.ENTER);
	  actions.build().perform();
	  
	  WebElement webElement4 = ifindElement("zipperpullover_custom2");
	  actions.moveToElement(webElement4);
	  actions.click();
	  actions.sendKeys("Polyester");
	  actions.sendKeys(Keys.ENTER);
	  actions.build().perform();
	  
	  WebElement webElement5 = ifindElement("zipperpullover_quantity");
	  actions.moveToElement(webElement5);
	  webElement5.click();
	  webElement5.sendKeys(Keys.CONTROL,"a");
	  webElement5.sendKeys("4");
	  actions.build().perform();
	  
	  ifindElement("zipperpullover_addtocart").click();
	  
	  ifindElement("cart_popup").click();
	  
	  String cowboyhat_actual_size = ifindElement("cowboyhat_checkout_size").getText();
	  String[] parts = cowboyhat_actual_size.split(":");
	  cowboyhat_actual_size = parts[1].trim();
	  Assert.assertEquals(cowboyhat_actual_size, prop.getProperty("cowboyhat_expected_size"));
	  System.out.println(cowboyhat_actual_size);
	  
	  String cowboyhat_actual_quantity = ifindElement("cowboyhat_checkout_quantity").getAttribute("value");
	  Assert.assertEquals(cowboyhat_actual_quantity, prop.getProperty("cowboyhat_expected_quantity"));
	  System.out.println(cowboyhat_actual_quantity);
	  
	  String zipperpullover_actual_custom1 = ifindElement("zipperpullover_checkout_custom1").getText();
	  String[] parts2 = zipperpullover_actual_custom1.split("input");
	  zipperpullover_actual_custom1 = parts2[1].trim();
	  Assert.assertEquals(zipperpullover_actual_custom1, prop.getProperty("zipperpullover_expected_custom1"));
	  System.out.println(zipperpullover_actual_custom1);
	  
	  String zipperpullover_actual_custom2 = ifindElement("zipperpullover_checkout_custom2").getText();
	  String[] parts3 = zipperpullover_actual_custom2.split("list");
	  zipperpullover_actual_custom2 = parts3[1].trim();
	  Assert.assertEquals(zipperpullover_actual_custom2, prop.getProperty("zipperpullover_expected_custom2"));
	  System.out.println(zipperpullover_actual_custom2);
	  
	  String zipperpullover_actual_quantity = ifindElement("zipperpullover_checkout_quantity").getAttribute("value");
	  Assert.assertEquals(zipperpullover_actual_quantity, prop.getProperty("zipperpullover_expected_quantity"));
	  System.out.println(zipperpullover_actual_quantity);
	  
	  ifindElement("checkout").click();
	  
	  
	  String[] info_xpath = {"email","username","name","password","password2","firstname","lastname","address1", "zip", "city"};
	  String[] info_expected = {"email_expected","username_expected","name_expected","password_expected","password2_expected","firstname_expected","lastname_expected","address1_expected", "zip_expected", "city_expected"};
	  fillInfo(info_xpath,info_expected);
	  
	  WebElement webElement6 = ifindElement("country");
	  actions.moveToElement(webElement6);
	  webElement6.click();
	  webElement6 = ifindElement("country_with_drop");
	  webElement6.click();
	  webElement6.sendKeys(prop.getProperty("country_expected"));
	  webElement6.sendKeys(Keys.ENTER);
	  actions.build().perform();
	
	  
	  
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  ifindElement("checkoutasguest").click();;
	  
	  
	  String[] bill_expected = {"email_expected","username_expected","name_expected","firstname_expected","lastname_expected","address1_expected", "zip_expected", "city_expected", "country_expected"};
	  String[] bill_actual = {"email_bill","username_bill","name_bill","firstname_bill","lastname_bill","address1_bill", "zip_bill", "city_bill", "country_bill"};
	  verifyFilledInfo(bill_actual,bill_expected);
	  
	  ifindElement("tos").click();
	  ifindElement("confirmpurchase").click();
	  ifindElement("vieworder").click();
	  
	 
	  
	  
	  
	  // Verify Bill To info on Order Information page
	  String[] order_billto_actual= {"email_billto","firstname_billto","lastname_billto","address1_billto", "zip_billto", "city_billto","country_billto"};
	  String[] order_billto_expected = {"email_expected","firstname_expected","lastname_expected","address1_expected", "zip_expected", "city_expected","country_expected"};
	  verifyFilledInfo(order_billto_actual,order_billto_expected);
	  
	  
	  cowboyhat_actual_size = ifindElement("cowboyhat_checkout_size").getText();
	  parts = cowboyhat_actual_size.split(":");
	  cowboyhat_actual_size = parts[1].trim();
	  Assert.assertEquals(cowboyhat_actual_size, prop.getProperty("cowboyhat_expected_size"));
	  System.out.println(cowboyhat_actual_size);
	  
	  cowboyhat_actual_quantity = ifindElement("cowboyhat_order_quantity").getText().trim();
	  Assert.assertEquals(cowboyhat_actual_quantity, prop.getProperty("cowboyhat_expected_quantity"));
	  System.out.println(cowboyhat_actual_quantity);
	  
	  zipperpullover_actual_custom1 = ifindElement("zipperpullover_checkout_custom1").getText();
	  parts2 = zipperpullover_actual_custom1.split("input");
	  zipperpullover_actual_custom1 = parts2[1].trim();
	  Assert.assertEquals(zipperpullover_actual_custom1, prop.getProperty("zipperpullover_expected_custom1"));
	  System.out.println(zipperpullover_actual_custom1);
	  
	  zipperpullover_actual_custom2 = ifindElement("zipperpullover_checkout_custom2").getText();
	  parts3 = zipperpullover_actual_custom2.split("list");
	  zipperpullover_actual_custom2 = parts3[1].trim();
	  Assert.assertEquals(zipperpullover_actual_custom2, prop.getProperty("zipperpullover_expected_custom2"));
	  System.out.println(zipperpullover_actual_custom2);
	  
	  zipperpullover_actual_quantity = ifindElement("zipperpullover_order_quantity").getText().trim();
	  Assert.assertEquals(zipperpullover_actual_quantity, prop.getProperty("zipperpullover_expected_quantity"));
	  System.out.println(zipperpullover_actual_quantity);
	  
	  
	  
    }
    
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "browserDrivers/Chrome/chromedriver.exe");
		driver = new ChromeDriver();
		
		// Implicit wait for a element in 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
		
		
		

	}

	@AfterMethod
	public void afterMethod() {
		/*driver.close();
		driver.quit();*/
	}
	
	public WebElement ifindElement(String key){
		WebElement element = driver.findElement(By.xpath(prop.getProperty(key)));
		return element;
	}
	
	// First locate fields using xpath then fill found fields with expected values from properties file
	public void fillInfo(String[] info_xpath, String[] info_expected){ 
		int j = 0;
		for (String i: info_xpath) {           
		        //Do your stuff here
		        ifindElement(i).sendKeys(prop.getProperty(info_expected[j]));
		        j+=1;
		    }
	}
	
	

	
	
	public void verifyFilledInfo(String[] bill_actual, String[] bill_expected){ 
		int j = 0;
		String actual = "";
		for (String i: bill_actual) {           
		        //Do your stuff here
			    /*System.out.println("i: " + i);*/
				actual = ifindElement(i).getText();
				Assert.assertEquals(actual, prop.getProperty(bill_expected[j]));
				j+=1;
		        /*System.out.println("Actual bill: " + actual);
		        System.out.println("Expected bill: " + prop.getProperty(bill_expected[j]));*/
		        
		    }
	}

}
