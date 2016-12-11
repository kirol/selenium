package testingforstaticAPIs;

import org.testng.annotations.Test;

import SimpleCalc.SimpleCalc;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HappyPathTests {
  
  @Test 
  public void simpleAdd() {
	  int number1 = 10;
	  int number2 = 2;
	  int number3 = 12;
	  Assert.assertEquals(SimpleCalc.doAdd(number1, number2), number3);
  }
  
  @Test 
  public void simpleSubtract() {
	  int number1 = 5;
	  int number2 = 2;
	  int number3 = 3;
	  Assert.assertEquals(SimpleCalc.doSubtract(number1, number2), number3);
  }
  
  @Test 
  public void simpleMultiple() {
	  int number1 = 10;
	  int number2 = 2;
	  int number3 = 20;
	  Assert.assertEquals(SimpleCalc.doMultiple(number1, number2), number3);
  }
  
  @Test 
  public void simpleDivide() {
	  int number1 = 10;
	  int number2 = 2;
	  int number3 = 5;
	  Assert.assertEquals(SimpleCalc.doDivide(number1, number2), number3);
  }
  
  @Test 
  public void simpleModulo() {
	  int number1 = 10;
	  int number2 = 2;
	  int number3 = 0;
	  Assert.assertEquals(SimpleCalc.doModulo(number1, number2), number3);
  }
  
  @Test 
  public void maxBoundaryValue() {
	  int number1 = 2147483640;
	  int number2 = 7;
	  int number3 = 2147483647;
	  Assert.assertEquals(SimpleCalc.doAdd(number1, number2), number3);
  }
  
  @Test 
  public void minBoundaryValue() {
	  int number1 = -2147483640;
	  int number2 = -7;
	  int number3 = -2147483647;
	  Assert.assertEquals(SimpleCalc.doAdd(number1, number2), number3);
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
