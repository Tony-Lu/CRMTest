package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlePopUp extends TestBase  {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		
		// this a javascript pop-up, belong to this browser
		
		// use Alert API
		
		Alert alert = driver.switchTo().alert();
		alert.getText();
		System.out.println(alert.getText());
		String text = alert.getText();
		if(text.equals("Please enter a valid username")) {
			System.out.println("correct alert message");
		}
		else {
			System.out.println("in-correct alert message");
		}
		
		alert.accept();  // click on OK btn
		
		//alert.dismiss(); // click on CANCEL btn
		
		
		
		
	}	
		
}
