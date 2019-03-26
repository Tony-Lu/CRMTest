package com.crm.qa.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;



public class loginDataProviderTest {
	
	
	
	
	public static void main(String[] args) throws IOException {	
		//System.setProperty("webdriver.chrome.driver", "F:\\toolDownloaded\\chromedriver.exe");
	
//	String projectPath = System.getProperty("user.dir");
//	ReadExcel excel = new ReadExcel();
//	 Object[][] data= excel.getTestData("F:\\Java\\CRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\", "testData.xlsx", "Credentials");

	//System.out.println(data[0][1]);
			
		File xlsFile = new File("F:\\Java\\CRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\testData.xlsx");
		 
		// 工作表
		Workbook workbook = WorkbookFactory.create(xlsFile);
 
		// 表个数。
		int numberOfSheets = workbook.getNumberOfSheets();
 
		// 遍历表。
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
 
			// 行数。
			int rowNumbers = sheet.getLastRowNum() + 1;
 
			// Excel第一行。
			Row temp = sheet.getRow(0);
			if (temp == null) {
				continue;
			}
 
			int cells = temp.getPhysicalNumberOfCells();
 
			// 读数据。
			for (int row = 0; row < rowNumbers; row++) {
				Row r = sheet.getRow(row);
				for (int col = 0; col < cells; col++) {
					System.out.print(r.getCell(col).toString()+" ");
				}
 
				// 换行。
				System.out.println();
			}
		}
	}


			
//	WebDriverManager.chromedriver().setup(); 	
//	driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	/////////driver.manage().deleteAllCookies();
//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	
	

	//@BeforeMethod
//	public void setUp() {
//		
//		//initialization();
//	}
	
//	@DataProvider
//	public Object[][] getLoginData() {
//		Object data[][] = TestUtil.getTestData("HRMOrange_Credentials");
//		return data;
//	}
	
	//@Test//(dataProvider = "getLoginData")
//	public void loginDataProviderTest(String username, String password) {
	//public void loginDataProviderTest() {	
//		driver.findElement(By.id("txtUsername")).sendKeys("admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
	//}
	
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
		//driver.quit();
		
//	}
	
		
}
