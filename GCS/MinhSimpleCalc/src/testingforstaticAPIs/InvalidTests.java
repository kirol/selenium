package testingforstaticAPIs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import SimpleCalc.SimpleCalc;

public class InvalidTests {
	
  @Test (expectedExceptions=ArithmeticException.class)
  public void divideByZero() {
	  int number1 = 1;
	  int number2 = 0;
	  SimpleCalc.doDivide(number1, number2);
  }
  
  @Test (expectedExceptions=Exception.class)
  public void aboveUpperLimit(){
	  int number1 = 2147483640;
	  int number2 = 8;
	  SimpleCalc.doAdd(number1, number2);
  }
  
  @Test (expectedExceptions=Exception.class)
  public void belowLowerLimit(){
	  int number1 = -2147483640;
	  int number2 = -8;
	  SimpleCalc.doAdd(number1, number2);
  }
  

  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
