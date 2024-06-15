package com.MyMavenDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.apache.poi.ss.formula.functions.EDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D03OHRMLoginlogout {
	
	WebDriver driver;
	String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String actUrl;
	
  @Test(dataProvider = "getLoginDetails")
  public void loginToOHRM(String un, String ps) {
	  
	  driver.findElement(By.name("username")).sendKeys(un);
	  driver.findElement(By.name("password")).sendKeys(ps);
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  
	/*  actUrl = driver.getCurrentUrl();
	  Assert.assertEquals(actUrl,expUrl);*/
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  
	  
	  if (expUrl.equals(actUrl)) {
		  
		  	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
			 driver.findElement(By.linkText("Logout")).click();
	

		
	}
  }


  @DataProvider
  public Object[][] getLoginDetails() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "Faisal", "faisal123" },
      new Object[] { "Ahmed", "ahmed123"},
      new Object[] { "Khan", "khan123"},
      new Object[] { "Pathaan", "pathaan123"},
      new Object[] { "Admin", "admin123"},
    };
  }
  @BeforeTest
  public void beforeTest() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterTest
  public void afterTest() {
	  
	 driver.close();
  }

}
