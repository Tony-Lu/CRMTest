package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtableDemo extends TestBase {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		//below is OrangeHRM Admin webtable absolute xpath == just at right side of a checkbox:
		
		//*[@id="resultTable"]/tbody/tr[2]/td[2]/a

		//*[@id="resultTable"]/tbody/tr[3]/td[2]/a

		//*[@id="resultTable"]/tbody/tr[4]/td[2]/a
		
		
		// method -1 // not working on HRM application, dur to the checkBox
//		String before_xpath = "//*[@id=\"resultTable\"]/tbody/tr[";
//		String after_xpath = "]/td[2]/a";
//		
//		for(int i=1; i<=11; i++) {
//			String usernameValue = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//			//System.out.println(usernameValue);
//			
//				if(usernameValue.contains("JMorgan")) {
//					driver.findElement(By.xpath("//*[@id=\\\"resultTable\\\"]/tbody/tr["+i+"]/td[2]/a")).click();
//				}			
//		}
		
		//method-2
		//a[text()='JMorgan']//parent::td[@class='left']//preceding-sibling::td//input[@type='checkbox']
		String username_before_xpath = "//*[@id=\"resultTable\"]/tbody/tr[";
		String username_after_xpath = "]/td[2]/a";
		
		String checkbox_before_xpath = "//a[text()='";
		String checkbox_after_xpath = "']//parent::td[@class='left']//preceding-sibling::td//input[@type='checkbox']";
		
		
		for(int i=1; i<=10; i++) {
			String usernameValue = driver.findElement(By.xpath(username_before_xpath+i+username_after_xpath)).getText();
			//System.out.println(usernameValue);
			
				if(usernameValue.contains("john.smith")) {
					driver.findElement(By.xpath(checkbox_before_xpath+usernameValue+checkbox_after_xpath)).click();
				}			
		}
		
		
		
	}

}
