package com.MyMavenDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class D04DDF_OHRM {
	
	WebDriver driver;
	String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String actUrl;
	
  @Test(dataProvider = "getLoginData", dataProviderClass = com.Utilitis.ForLoginData.class)
  public void loginToOHRM(String un, String ps) {
	  
	  driver.findElement(By.name("username")).sendKeys(un);
	  driver.findElement(By.name("password")).sendKeys(ps);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  
	  actUrl = driver.getCurrentUrl();
	  Assert.assertEquals(actUrl,expUrl);
	  
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
  
  
  

  @BeforeTest
  public void beforeTest() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterTest
  public void afterTest() {
  }

}
