package com.crm.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


import io.github.bonigarcia.wdm.WebDriverManager;

public class second_BootstrapDropBox extends TestBase {
	
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
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		
//		WebElement dropdownBtn = driver.findElement(By.id("dropdownMenuButton"));
//		
//		scrollPageIntoViewByJS(dropdownBtn, driver);
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu')]//a"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Another action")) {
				list.get(i).click();
				break;
			}			
		}
		
		
		

	}
	
	public static void scrollPageIntoViewByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

}
