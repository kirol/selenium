/**
 * @author Thanh Tran
 *
 */

package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testing.DataDrivenTest.calculator;

public class DataDrivenTest2 {
	WebDriver driver;

	@Test(dataProvider="calculatorTestData")
	public void testSimpleCalculator(testing.DataDrivenTest2.calculator calc) {
		driver.get("https://www.e-access.att.com/pkmslogin.form");
		WebElement username = driver.findElement(By.xpath("html/body/form[1]/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/input"));
		username.sendKeys(calc.username);
		WebElement password = driver.findElement(By.xpath("html/body/form[1]/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td/input"));
		password.sendKeys(calc.password);
		WebElement submitBtn = driver.findElement(By.xpath("html/body/form[1]/table[3]/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td/input"));
		submitBtn.click();
		WebElement okBtn = driver.findElement(By.xpath(".//*[@id='srv_successok']/input"));
		okBtn.click();
		
		
	}

	/* Just for checking data provider.... */
	/*@Test(dataProvider = "calculatorTestData")
	public void checkTestData(testing.DataDrivenTest2.calculator calc) {
		System.out.println("no1: " + calc.username);
		System.out.println("no2: " + calc.password);
	}
*/


	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDrivers/Chrome/chromedriver.exe");
		 driver = new ChromeDriver();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("TestData/testScreenShot.jpg"));
			
	   }    
		driver.close();
		driver.quit();
	}
	/*
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}*/

	@DataProvider(name = "calculatorTestData")
	public Object[][] calculatorData() {
		List<testing.DataDrivenTest2.calculator> testData = new ArrayList<testing.DataDrivenTest2.calculator>();
		
		try {
			String testDataFilePath = "TestData/Timesheet.xlsx";
			FileInputStream inputStream = new FileInputStream(new File(testDataFilePath));

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet firstSheet = workbook.getSheet("Sheet2");
			XSSFRow nextRow;
			Iterator iterator = firstSheet.rowIterator();

			while (iterator.hasNext()) {
				nextRow = (XSSFRow) iterator.next();
				Iterator cellIterator = nextRow.cellIterator();
				String username = "";
				String password = "";
				String n01 = "";
				String n02 = "";
				String n03 = "";
				String n04 = "";
				String n05 = "";
				String n06 = "";
				String n07 = "";
				String n08 = "";
				String n09 = "";
				String n10 = "";
				String n11 = "";
				String n12 = "";
				String n13 = "";
				String n14 = "";
				String n15 = "";
				String e01 = "";
				String e02 = "";
				String e03 = "";
				String e04 = "";
				String e05 = "";
				String e06 = "";
				int __count = 0;
				String __tmpStr = "";
				while (cellIterator.hasNext()) {
					XSSFCell cell = (XSSFCell) cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						__tmpStr = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						__tmpStr = Double.toString(cell.getNumericCellValue());
						break;
					}
					if (__count == 0)
						username = __tmpStr;

					if (__count == 1)
						password = __tmpStr;

					if (__count == 2)
						n01 = __tmpStr;

					if (__count == 3)
						n02 = __tmpStr;

					if (__count == 4)
						n03 = __tmpStr;

					if (__count == 5)
						n04 = __tmpStr;

					if (__count == 6)
						n05 = __tmpStr;

					if (__count == 7)
						e01 = __tmpStr;

					if (__count == 8)
						e02 = __tmpStr;

					if (__count == 9)
						n06 = __tmpStr;

					if (__count == 10)
						n07 = __tmpStr;

					if (__count == 11)
						n08 = __tmpStr;

					if (__count == 12)
						n09 = __tmpStr;

					if (__count == 13)
						n10 = __tmpStr;

					if (__count == 14)
						e03 = __tmpStr;

					if (__count == 15)
						e04 = __tmpStr;

					if (__count == 16)
						n11 = __tmpStr;

					if (__count == 17)
						n12 = __tmpStr;

					if (__count == 18)
						n13 = __tmpStr;

					if (__count == 19)
						n14 = __tmpStr;

					if (__count == 20)
						n15 = __tmpStr;

					if (__count == 21)
						e05 = __tmpStr;

					if (__count == 22)
						e06 = __tmpStr;

					__count++;
					
					
				}
				testing.DataDrivenTest2.calculator _tmpCalc = new calculator(username, password, n01,  n02,  n03,  n04,  n05,  e01,  e02,  n06,  n07,  n08,  n09,  n10,  e03,  e04,  n11,  n12,  n13,  n14,  n15,  e05,  e06);
				
				testData.add(_tmpCalc);
			}
			inputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		Object[][] objArray = new Object[testData.size()][];
		for (int i = 0; i < testData.size(); i++) {
			objArray[i] = new Object[1];
			objArray[i][0] = testData.get(i);
		}

		return objArray;
	}

	class calculator {
		String username;
		String password;
		String n01;
		String n02;
		String n03;
		String n04;
		String n05;
		String n06;
		String n07;
		String n08;
		String n09;
		String n10;
		String n11;
		String n12;
		String n13;
		String n14;
		String n15;
		String e01;
		String e02;
		String e03;
		String e04;
		String e05;
		String e06;

		calculator(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8, String a9, String a10, String a11, String a12, String a13, String a14, String a15, String a16, String a17, String a18, String a19, String a20, String a21, String a22, String a23) {
			username = a1;
			password = a2;
			n01 = a3;
			n02 = a4;
			n03 = a5;
			n04 = a6;
			n05 = a7;
			n06 = a8;
			n07 = a9;
			n08 = a10;
			n09 = a11;
			n10 = a12;
			n11 = a13;
			n12 = a14;
			n13 = a15;
			n14 = a16;
			n15 = a17;
			e01 = a18;
			e02 = a19;
			e03 = a20;
			e04 = a21;
			e05 = a22;
			e06 = a23;
		}
	}

}
