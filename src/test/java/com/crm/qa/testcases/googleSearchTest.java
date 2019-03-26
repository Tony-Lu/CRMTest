package com.crm.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import com.crm.qa.base.TestBase;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearchTest extends TestBase {
	
	
	public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver", "F:\\toolDownloaded\\chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		//Logger log = Logger.getLogger(LoginPageTest.class);
		//log.info("****************************** Starting test cases execution  *****************************************");

		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		//log.info("launching chrome broswer");
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.google.ca");
//		log.info("entering application URL");
//		log.warn("Hey this just a warning message");
//		log.fatal("hey this is just fatal error message");
//		log.debug("this is debug message");
		
		
		
		driver.findElement(By.name("q")).sendKeys("testing");
		
		//returning all the child "li"s under "ul":
		List <WebElement> linkList = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		
		System.out.println("total number of suggestions in search box: " + linkList.size());
		
		//if we need locate a specific search result, let's say in 6th line, xpath as below:
		//ul[@role='listbox']//li/descendant::span//b[text()=' internet speed']
		//ul[@role='listbox']//li/descendant::span[text()='testing machine']
		
//		String before_target_search_result = "//ul[@role='listbox']//li/descendant::span[text()='";
//		String after_target_search_result = "']";
		
		for(int i=0; i<linkList.size();i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);			
			
			// trim the data to get the value we need:
			//String linkValue = linkText.substring(8);
			
			if(linkText.contains("machine")) {
//				driver.findElement(By.xpath(before_target_search_result+linkText+after_target_search_result)).click();
				// or, simple way is:
				linkList.get(i).click();
				break;
				//System.out.println("testing target clicked successfully");
			}
			
			
		}
		
		
		driver.close();

		
		
		
	}

}
