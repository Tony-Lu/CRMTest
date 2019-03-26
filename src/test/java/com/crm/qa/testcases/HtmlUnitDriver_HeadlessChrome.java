package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HtmlUnitDriver_HeadlessChrome {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		
		ChromeOptions options = new ChromeOptions();
		// the below 2 steps CAN NOT be skipped, otherwise it will launch chrome minimize as an icon
		options.addArguments("window-size=1400,800");			
		options.addArguments("headless");
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		WebDriver driver = new ChromeDriver(options);	
		
		// htmlUnitDriver is not available in Selenium 3.x version
		// need download HtmlUnitDriver JAR file 
		
		// now only Chrome, firefox, has headless driver
		
		
		//advantages:
		//1. testing is happening behind the scene -- no browser is launched
		//2. very fast ---- performance of the test script
		//3. not suitable for actions class -- user actions: mousemovement, doubleClick, drag and drop
		//4. Ghost Driver --- Headless browser
		
		//e.g: HtmlUnitDriver  -- JavaScript
		//     PhantamJS       -- JavaScript	xxx not maintained right now, 
		//		puppeteer      -- with Maven Repository
		
		
		
		//WebDriver driver = new HtmlUnitDriver(); // for unknown reason, not working
		
		
		//driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("before login , title is: " +driver.getTitle());
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("after login , title is: " + driver.getTitle());
		driver.close();
		

	}

}
