package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


import io.github.bonigarcia.wdm.WebDriverManager;

public class selectCalendarByJS extends TestBase {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// adding browser version:
		// WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		///////// driver.manage().deleteAllCookies();
		// below is : dynamic wait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		
		// here using JS executor,
		WebElement date = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		//ctl00_mainContent_txt_Fromdate // ctl00_mainContent_view_date1
		String dateVal = "31-03-2019";
		selectDateByJS(driver, date, dateVal);
		//button[@class='ui-datepicker-trigger']//preceding-sibling::input[@id='ctl00_mainContent_txt_Fromdate']
		
		//below is using regular selenium:
//		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='31']")).click();
		
		
		

	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}

}
