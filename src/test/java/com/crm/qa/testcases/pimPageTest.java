package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.android.dx.io.Code.Try;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PIMPage;
import com.crm.qa.util.TestUtil;

import net.sourceforge.htmlunit.corejs.javascript.ast.TryStatement;

public class pimPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AdminPage adminPage;
	PIMPage pIMPage;
	
	String sheetName = "sheet1";
	
	public pimPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		adminPage = new AdminPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickPIMTab();
	}
	
	 
	
	@Test(priority = 1)
	public void verifyconfigurationTabTest() {
		System.out.println(driver.getTitle());
		//Assert.assertEquals(pIMPage.verifyconfigurationTab(), "configuration is displayed");
		
	}
	
//	@DataProvider
//	public Object[][] getTestData() {
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//		
//	}
	
	
	
//	@Test(priority = 2,dataProvider = "getTestData")	// this step with error, need re-do
	@Test(priority = 2)	
	public void verifyinputFieldNameTest(String inpuVal) {
		
		pIMPage.verifyInputFieldName(inpuVal);
		
	}
	
	@Test(priority = 3)
	public void verifySelectScreenValByNameTest() {
		
		pIMPage.selectScreenValByName("Dependents");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
	
	

}
