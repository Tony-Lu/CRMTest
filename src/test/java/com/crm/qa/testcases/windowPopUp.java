package com.crm.qa.testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowPopUp extends TestBase {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();
		
		// using .getWindowHandles , is because that the pop-up window contains multi-objects
		// below will return a set of obj:		
		Set <String> handler = driver.getWindowHandles(); // this is only can be used in runtime to get 
		// get value from set object:
		Iterator <String> itVal = handler.iterator();
		
		String parentWindowId = itVal.next();
		System.out.println("parent window id is: " + parentWindowId);	// shift handler from 1st obj to 2nd obj
		
		String childtWindowId = itVal.next();
		System.out.println("child window id is: " + childtWindowId);
		
		driver.switchTo().window(childtWindowId); // this step shift handler from parent window to child window
		System.out.println("child window pop up title: " + driver.getTitle());
		driver.close(); // dont use driver.quit  --- this will close all browsers // now, driver is for child window
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window pop up title: " + driver.getTitle());
		
		 
		
		
		

	}

}
