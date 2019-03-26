package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class AdminPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//testUtil = new TestUtil();
		adminPage = new AdminPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickAdminMenu();
	}
	
	@Test(priority = 1)
	public void verifyAddButtonTest() {
		Assert.assertTrue(adminPage.verifyAddButton(),"Add button not been displayed");
		
	}
	
	@Test(priority = 2)
	public void verifyCheckbox1SelectTest() {
//		adminPage.selectCheckBox1ByName("hannah.flores");
//		adminPage.selectCheckBox1ByName("john.smith");
		adminPage.selectCheckBox1ByName("ankita3");
		// pending assertion ????		
	}
	
		
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}
	
	

}
