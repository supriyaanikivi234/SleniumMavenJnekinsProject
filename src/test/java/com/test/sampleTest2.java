package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleTest2 {
WebDriver driver;
	
	@BeforeSuite
	public void setup() 
	{

		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("opened chrome browser");
			
		} else if(System.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("opened firefox browser");
			
		} else if(System.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("opened edge browser");
		}
	  
		
		driver.manage().window().maximize();
		driver.get(System.getProperty("URL"));
		//driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	 @AfterSuite
	 public void tearup() 
	 {
	driver.close();
	 }
	 
	 @Test
	 public void testcase1()
	 {
		 System.out.println("visited page successfully-Testcase1 passed");
	 }
	
	
}
