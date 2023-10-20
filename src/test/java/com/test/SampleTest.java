package com.test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class SampleTest
{
	WebDriver driver;
	
	@BeforeSuite
	public void setup() 
	{

		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(System.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if(System.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
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
	  @Test(priority=0)
	    public void login() throws InterruptedException {
	        driver.findElement(By.id("username")).sendKeys("student");
	        Thread.sleep(1000);
	        System.out.println("username entered");
	        driver.findElement(By.id("password")).sendKeys("Password123");
	        Thread.sleep(1000);
	        System.out.println("password entered");
	        driver.findElement(By.id("submit")).click();
	        Thread.sleep(1000);
	        System.out.println("clicked button entered");
	        System.out.println("on the new page");
	    }
	
	@Test(priority=1)
	public void testcase1()
	{
		// Verify new page URL contains
				// practicetestautomation.com/logged-in-successfully/
				String originalUrl = "https://practicetestautomation.com/logged-in-successfully/";
				String currentURL = driver.getCurrentUrl();

				if (originalUrl.equals(currentURL)) {
					System.out.println("1.testcase passed");
				} else {
					System.out.println("1.testcase failed");
				}

	}
	@Test(priority=2)
	public void testcase2()
	{
		// Verify new page contains expected text ('Congratulations' or 'successfully
				// logged in')
				String originalText = "Congratulations student. You successfully logged in!";
				String Actaultext = driver.findElement(By.className("has-text-align-center")).getText();

				if (originalText.equals(Actaultext)) {
					System.out.println("2.testcase passed");
				} else {
					System.out.println("2.testcase failed");
				}

				System.out.println("text"+Actaultext);
	}
	
	@Test(priority=3)
	public void testcase3()
	{
		
		String originalTitle = "Logged In Successfully | Practice Test Automation";
		String ActaulTitle = driver.getTitle();
		System.out.println("title is : "+ActaulTitle);     
		

		if (originalTitle.equals(ActaulTitle)) {
			System.out.println("3.testcase passed");
		} else {
			System.out.println("3.testcase failed");
		}
		
		
		driver.findElement(By.linkText("Log out")).click();
	}
	 
	@Test(priority=4)
	public void testcase4()
	{

	String originalUrl1 = "https://practicetestautomation.com/practice-test-login/";
	String currentURL1 = driver.getCurrentUrl();

	if (originalUrl1.equals(currentURL1)) {
		System.out.println("4.testcase passed");
	} else {
		System.out.println("4.testcase failed");
	}
	
	System.out.println("added the code changes");
	System.out.println("updating code to sub barnch from local repository or eclipse to github repository");
	
	}
	
}