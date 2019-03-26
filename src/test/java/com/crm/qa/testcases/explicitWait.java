package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class explicitWait extends TestBase  {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		// below is : dynamic wait
		
		// this is for page load
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		// this is for object in the page load
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);  
		driver.get("https://www.markham.ca/wps/portal/home");
		
		// explicit wait : is specificly wait for an object		
		clickOn(driver, driver.findElement(By.xpath("//*[@id=\"signIn\"]")), 20);
		
		// if 2 seconds found the obj, then process will going on to the next step without waiting remaining 18 seconds

	}
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		
	}
	
	
	

}
