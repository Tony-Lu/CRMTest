package com.crm.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathDemo extends TestBase {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//driver.get("https://www.mycredit.cn/");
		//driver.findElement(By.xpath("//a[text()='登录']")).click();
		// handle dynamic id? use contains()
		//driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
		//driver.findElement(By.xpath("//a[starts-with(text(),'登录')]")).click();
		//driver.findElement(By.xpath("//a[ends-with(text(),'登录')]")).click(); === this is not working 
		
		//driver.findElement(By.xpath("//input[@class='el-input__inner']")).sendKeys("13918819081");
		//if we need locate a specific search result, let's say in 6th line, xpath as below:
		//ul[@role='listbox']//li/descendant::span//b[text()=' internet speed']
		//ul[@role='listbox']//li/descendant::span[text()='testing machine']
				
		//String before_target_search_result = "//ul[@role='listbox']//li/descendant::span[text()='";
		//String after_target_search_result = "']";
		//returning all the child "li"s under "ul":   ===  Google search page
		//List <WebElement> linkList = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
				
		
		driver.get("https://www.ebay.ca/");
		
		//get total count of links on this page
		
		//all the links are represented by <a> html tag:
		
		List <WebElement> linkList = driver.findElements(By.tagName("a"));		
		// get size of linkList:		
		System.out.println(linkList.size());
		
		//get the text of each links
		for(int i=0;i<linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);			
		}
		
		
	}

}
