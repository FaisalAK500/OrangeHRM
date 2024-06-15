package com.MyMavenDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D01OpenGoogle {

	public static void main(String[] args) {

		WebDriverManager .firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Title:" + driver.getTitle());
		
		driver.quit();
		
		
	}

}
