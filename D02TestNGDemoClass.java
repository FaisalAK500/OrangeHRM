package com.MyMavenDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D02TestNGDemoClass {
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("I am in Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("I am in After Method");

  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("I am in Before Test");

  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("I am in After Test");

  }

}
