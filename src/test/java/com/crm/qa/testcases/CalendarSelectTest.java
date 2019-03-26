package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarSelectTest extends TestBase {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); 
		
		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();			
		
		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://fullcalendar.io/");
		
		Thread.sleep(3000);
		
		String dateToday = "8-March-2019";
		String dateArr[] = dateToday.split("-"); // {8, March, 2019}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		//below is from tutorial video for selecting the dropdown list:
//		Select select = new Select(driver.findElement(By.name("country")));
//		select.selectByVisibleText("China");
		
//		Select select1 = new Select(driver.findElement(By.name("slcYear")));
//		select.selectByVisibleText(year);
		
		//below is the 1st row, starting with grey area
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[2]/table/thead/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[2]/table/thead/tr/td[1]/a


		// 2nd row
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[2]/div[1]/table/tbody/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[2]/div[2]/table/thead/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[2]/div[2]/table/thead/tr/td[1]/a



		//3rd row
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[3]/div[1]/table/tbody/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[3]/div[2]/table/thead/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[3]/div[2]/table/thead/tr/td[1]/a



		//last row == total 6 rows 
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[6]/div[1]/table/tbody/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[6]/div[2]/table/thead/tr/td[1]
		//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[6]/div[2]/table/thead/tr/td[1]/a
		
		
		// below is Feb 24, 2019 - xpath, customized:
		//a[@class='fc-day-number' and text()='24']//parent::td[@class='fc-day-top fc-sun fc-other-month fc-past']
		
		// Mar 08, 2019: parent class - xpath, customized
		//a[@class='fc-day-number' and text()='8']//parent::td[@class='fc-day-top fc-fri fc-today ']
		//a[@class='fc-day-number' and text()='8']
		
		String beforeXpath = "//a[@class='fc-day-number' and text()='";
		String afterXpath = "']";
//		
//		final int totalWeekDays = 7;
//		boolean flag = false;
//		for(int rowNum=2; rowNum<=7; rowNum++) {
//			for(int colNum=1; colNum<=totalWeekDays; colNum++) {
//				try{
//				String dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]/a")).getText();
				//}catch (NoSuchElementException e) {
				//System.out.println("please enter a correct date value");
				//flag=false;
				//break;
				//}
				//
				//System.out.println(dayVal);
				//if(dayval.equals(day)){
				//driver.findElement(By.xpath(beforeXpath+day+afterXpath)).click();
				//flag = true;
				//break;
				//}
//			}
//		}
//		if(flag) {
//			break;
//		}
		
		driver.findElement(By.xpath(beforeXpath+day+afterXpath)).click();
		
		
		
	}

}
