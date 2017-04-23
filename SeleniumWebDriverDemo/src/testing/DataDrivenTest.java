/**
 * @author Thanh Tran
 *
 */

package testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	WebDriver driver;

	@Test(testName = "SimpleCalculatorTest", dataProvider = "calculatorTestData")
	public void testSimpleCalculator(testing.DataDrivenTest.calculator calc) {
		driver.get("http://tranminhthanh.info/training/selenium/SimpleCalculator/");
		WebDriverWait _wait = new WebDriverWait(driver, 10); //wait for page to load in 10 seconds
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lblResult")));		
		driver.findElement(By.name("txtnumber1")).sendKeys(calc.number1 + "");
		driver.findElement(By.name("txtnumber2")).sendKeys(calc.number2 + "");
		Select slOperator = new Select(driver.findElement(By.name("slOperator")));
		slOperator.selectByVisibleText(calc.operator);
		String actualResTxt = driver.findElement(By.name("lblResult")).getText();
		Assert.assertEquals(actualResTxt.substring(8, actualResTxt.length()), calc.expectedResult);
	}

	/* Just for checking data provider.... 
	@Test(dataProvider = "calculatorTestData")
	public void checkTestData(testing.DataDrivenTest.calculator calc) {
		System.out.println("no1: " + calc.number1);
		System.out.println("no2: " + calc.number2);
		System.out.println("operator: " + calc.operator);
		System.out.println("result: " + calc.expectedResult);
	}*/
	


	@BeforeMethod
	public void setUp() {
		 System.setProperty("webdriver.chrome.driver", "browserDrivers/Chrome/chromedriver.exe");
		 driver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}

	@DataProvider(name = "calculatorTestData")
	public Object[][] calculatorData() {
		List<testing.DataDrivenTest.calculator> testData = new ArrayList<testing.DataDrivenTest.calculator>();
		;
		try {
			String testDataFilePath = "TestData/SimpleCalculatorTestData.xls";
			FileInputStream inputStream = new FileInputStream(new File(testDataFilePath));

			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				String __no2 = "";
				String __operator = "";
				String __no1 = "";
				String __expRes = "";
				int __count = 0;
				String __tmpStr = "";
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						__tmpStr = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						__tmpStr = Double.toString(cell.getNumericCellValue());
						break;
					}
					if (__count == 0)
						__no1 = __tmpStr;

					if (__count == 1)
						__no2 = __tmpStr;

					if (__count == 2)
						__operator = __tmpStr;

					if (__count == 3)
						__expRes = __tmpStr;

					__count++;
				}
				calculator _tmpCalc = new calculator(__no1, __no2, __operator, __expRes);
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
		String number1 = "";
		String number2 = "";
		String operator = "";
		String expectedResult = "";

		calculator(String _no1, String _no2, String _operator, String _expRes) {
			number1 = _no1;
			number2 = _no2;
			operator = _operator;
			expectedResult = _expRes;
		}
	}

}
