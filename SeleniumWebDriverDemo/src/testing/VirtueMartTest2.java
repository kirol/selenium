/**
 * @author Thanh Tran
 *
 */

package testing;

import org.testng.annotations.Test;

import testing.DataDrivenTest.calculator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class VirtueMartTest2 {
	WebDriver driver;
	WebDriverWait _wait;

	@Test(dataProvider="calculatorTestData")
	public void happyPathTest(Object[][] objArray) {
		/*driver.get("https://www.e-access.att.com/pkmslogin.form");	*/
		//TODO: Continue your test case developing here
		

	}

	@BeforeMethod
	public void beforeMethod() {
		/*System.setProperty("webdriver.chrome.driver", "browserDrivers/Chrome/chromedriver.exe");
		driver = new ChromeDriver();*/

	}

	@AfterMethod
	public void afterMethod() {
		/*driver.close();
		driver.quit();*/
	}

	@DataProvider(name = "calculatorTestData")
	public Object[][] calculatorData() {
		
		InputStream XlsxFileToRead = null;
		XSSFWorkbook workbook = null;
		Object[][] objArray = null;
		List testData = null;
		try {
			XlsxFileToRead = new FileInputStream("TestData/Timesheet.xlsx");

			//Getting the workbook instance for xlsx file
			workbook = new XSSFWorkbook(XlsxFileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//getting the first sheet from the workbook using sheet name. 
		// We can also pass the index of the sheet which starts from '0'.
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		XSSFRow row;
		XSSFCell cell;
		int objArraySize = 0;

		//Iterating all the rows in the sheet
		Iterator rows = sheet.rowIterator();
		

		while (rows.hasNext()) {
			objArraySize += 1;
			
			row = (XSSFRow) rows.next();
			
			testData = new ArrayList();

			//Iterating all the cells of the current row
			Iterator cells = row.cellIterator();
			
			

			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();


				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					/*System.out.print(cell.getStringCellValue() + " ");*/
					testData.add(cell.getStringCellValue());
					
				   
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					/*System.out.print(cell.getNumericCellValue() + " ");*/
					testData.add(cell.getNumericCellValue());
					
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					/*System.out.print(cell.getBooleanCellValue() + " ");*/
					testData.add(cell.getBooleanCellValue());
					
				} else { 
				}
			

			}
			System.out.println(testData);
			
			objArray = Arrays.copyOf(objArray, objArraySize);
			int tmpNum = objArraySize - 1;
			objArray[tmpNum] = testData.toArray();
			
			/*System.out.println();*/
			try {
				XlsxFileToRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		

		


		
		return objArray;
	}



}
