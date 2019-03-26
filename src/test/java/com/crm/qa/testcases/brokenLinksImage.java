package com.crm.qa.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinksImage extends TestBase  {
	
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// adding browser version:
		// WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		///////// driver.manage().deleteAllCookies();
		// below is : dynamic wait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.suanhua.org/");
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys("admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
		
		// go to admin page:		
		//driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
		//1. get the list of all the links and images:
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		
		linkList.addAll(driver.findElements(By.tagName("img")));
		System.out.println(linkList.size());
		
		List <WebElement> activeLinks = new ArrayList <WebElement>();
		
		//2. iterate linkList:   exclude all the links/images - does not have any href attribute	
		for(int i=0;i<linkList.size();i++) {
			System.out.println(linkList.get(i).getAttribute("href"));
			// below is for excluding links: not starting with "href", and also :   starting with "javascript"
			if(linkList.get(i).getAttribute("href") != null && (! linkList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkList.get(i));
			}
		}
		
		// 3. get the size of active links
		System.out.println(activeLinks.size());
		
		// 4. check the href url with http connection api:
		// 200: ok
		//404:  not found
		//500: internal error
		//400:  bad request
		for(int j=0;j<activeLinks.size();j++) {
			
		try {
			// get url, casting to HttpURLConnection api: return a connection http
			HttpURLConnection connection =(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String responseVal = connection.getResponseMessage(); // ok, or  error?
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"-----> "+responseVal);
			
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		}

		
		

	}

}
