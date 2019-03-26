package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutorConcept extends TestBase {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		// adding browser version:
		// WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		///////// driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://www.amazon.ca/");
//		driver.get("https://opensource-demo.orangehrmlive.com/");		
//		driver.findElement(By.id("txtUsername")).sendKeys("admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin1283");
		//driver.findElement(By.id("btnLogin")).click();		
		
		//executeScript -- this method is used to execute JavaScript code
		
//		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
//		flash(loginBtn, driver);  // this is to highlight object
		
		//drawBorder(loginBtn, driver); // draw a border
		// below is taking screenshot:
//		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("F:\\Java\\CRMTest\\screenshot\\test.png"));
		
		//once a bug detected, how to generate an alert during runtime ?
//		generateAlert(driver, "There is an issue with login button on login page");
//		driver.switchTo().alert().accept();
		
		// click on any element by using JS executor: 
		//clickElementByJS(loginBtn, driver);
		
		// refresh the page
		//1. using selenium
		//driver.navigate().refresh();
		//2. by suing JS executor:
		//refreshBrowserByJS(driver);
		
		// get page title by 1. selenium, 2. JS:
		driver.getTitle();
//		System.out.println(driver.getTitle());
		System.out.println(getTitleByJS(driver));
		
		// get page text, there is no method in Selenium, use JS executor
		//System.out.println(getPageInnerTextByJS(driver));
		
		//scrollPageDownByJS(driver);
		
		// scroll down until expected webelement is viewable:
		//WebElement linkedInLogoLink = driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")); 
		//WebElement linkedInLogoLink = driver.findElement(By.xpath("//div[text()='AmazonBasics Ceiling-Mount Bracket, Set of 2, Nickel']"));
		WebElement linkedInLogoLink = driver.findElement(By.xpath("//span[text()='Toys & Games bestsellers ']"));
		scrollPageIntoViewByJS(linkedInLogoLink, driver);

	}
	
	// highlight the login button:	
	public static void flash(WebElement element, WebDriver driver) {
		// this step is casting/converting driver into javascript
		JavascriptExecutor js = ((JavascriptExecutor) driver); // here js is an object
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)", element, driver); // this step make color change to: green
			changeColor(bgcolor, element, driver);		// this step make color change back to the original 
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
		
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static String getPageInnerTextByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageInnerText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageInnerText;
		
	}
	
	public static void scrollPageDownByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollPageIntoViewByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	

}
