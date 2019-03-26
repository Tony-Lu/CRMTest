package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileUploadPopUp extends TestBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get("https://html.com/input-type-file/");
		
		driver.findElement(By.id("fileupload")).sendKeys("F:\\Java\\CRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\test.txt");
		
		// this is a windows popup, not belong to browser
		//D:\New Career\Job-2019\post\BankofAmerica\test.txt
		
		
		
		

	}

}
