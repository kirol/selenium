/**
 * @author Thanh Tran
 *
 */

package testing;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebDriverCommandDemo {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("Before test start!!!");
		// Chrome
		System.setProperty("webdriver.chrome.driver", "browserDrivers/Chrome/chromedriver.exe");
		driver = new ChromeDriver();
		// Firefox
		//// https://github.com/mozilla/geckodriver/issues/173 - Crashed after
		// Quit
		// System.setProperty("webdriver.gecko.driver",
		// "browserDrivers/Firefox/geckodriver.exe");
		// driver = new FirefoxDriver();
		// IE
		// System.setProperty("webdriver.ie.driver",
		// "browserDrivers/IE/IEDriverServer.exe");
		// driver = new InternetExplorerDriver();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("test case done!!!");
		driver.close();
		driver.quit();
	}

	@Test
	public void testWebDriverInstanceCommands() {
		System.out.println("In test testWebDriverInstanceCommand!!!");
		// API get()
		driver.get("http://vnexpress.net");

		WebDriverWait _wait = new WebDriverWait(driver, 10); // wait for page to
																// load in 10
																// seconds
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

		// API getTitle()
		Assert.assertEquals("Tin nhanh VnExpress - Đọc báo, tin tức online 24h".equals(driver.getTitle()), true);
		// API getCurrentUrl()
		Assert.assertEquals("http://vnexpress.net/".equals(driver.getCurrentUrl()), true);

		// API findElement()
		WebElement we = driver.findElement(By.className("title_news"));
		System.out.println("Web Element with class 'title_news': " + we.getText());

		// API findElements()
		List<WebElement> wes = driver.findElements(By.className("width_50"));
		System.out.println("Web Elements: " + wes.size());
	}

	@Test
	public void testWebDriverNavigationCommands() {
		System.out.println("In test testWebDriverNavigationCommands!!!");
		// API to() with URL string
		driver.navigate().to("http://vnexpress.net");

		WebDriverWait _wait = new WebDriverWait(driver, 10); // wait for page to
																// load in 10
																// seconds
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

		// API to() with URL instance
		URL googleUrl;
		try {
			googleUrl = new URL("http://google.com");
			driver.navigate().to(googleUrl);
			_wait = new WebDriverWait(driver, 10); // wait for page to load in
													// 10 seconds
			_wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// API back()
		driver.navigate().back();
		_wait = new WebDriverWait(driver, 10); // wait for page to load in 10
												// seconds
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

		// API forward()
		driver.navigate().forward();
		_wait = new WebDriverWait(driver, 10); // wait for page to load in 10
												// seconds
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

		// API refresh()
		driver.navigate().refresh();
	}

	@Test
	public void testWebElementsCommands() {
		System.out.println("In test testWebElementsCommands!!!");
		WebDriverWait _wait;
		WebElement txtSearch;
		WebElement btnDoSearch;

		// API click() with URL string
		driver.navigate().to("http://vnexpress.net");

		_wait = new WebDriverWait(driver, 10); // wait for page to load in 10
												// seconds
		_wait.until(ExpectedConditions.elementToBeClickable(By.id("icon_thoitiet_small")));

		WebElement thoitietPopup = driver.findElement(By.id("icon_thoitiet_small"));
		thoitietPopup.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// API sendKey(), clear(), submit()
		// API getTagName(), getSize(), getLocation(), getAttribute()
		driver.navigate().to("http://bing.com");
		_wait = new WebDriverWait(driver, 10); // wait for page to load in 10
												// seconds
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sb_form_q")));

		txtSearch = driver.findElement(By.id("sb_form_q"));
		System.out.println("Tag name: " + txtSearch.getTagName());
		System.out.println("Size: " + txtSearch.getSize());
		System.out
				.println("Location: x - " + txtSearch.getLocation().getX() + ", y - " + txtSearch.getLocation().getY());
		System.out.println("Attribute 'autocorrect': " + txtSearch.getAttribute("autocorrect"));
		txtSearch.sendKeys("Who own Nokia?");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtSearch.clear();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtSearch.sendKeys("Microsoft Company");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnDoSearch = driver.findElement(By.id("sb_form_go"));
		btnDoSearch.submit();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
