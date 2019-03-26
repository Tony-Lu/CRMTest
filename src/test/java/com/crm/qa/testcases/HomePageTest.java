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
import com.crm.qa.pages.PIMPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	//TestUtil testUtil;
	AdminPage adminPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//testUtil = new TestUtil();
		adminPage = new AdminPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	// test cases should be independent with each other
	// before each t/c -- launch the browser and login
	// @test -- execute t/c
	// after each t/c -- close the browser
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM", "Home Page title not matched");
		// 3rd "..." is returned once validation failed
		
	}
	
	@Test(priority = 2)
	public void verifyWelcomeAdminLinkTest() {
		//testUtil.switchToFrame();// this is in case an obj is inside a frame
		Assert.assertTrue(homePage.verifyWelcomAdminLink(), "welcome admin link not been displayed");
		
	}
	
	@Test(priority = 3)
	public void verifyAdminMenuTest() {
		adminPage = homePage.clickAdminMenu();
				
	}
	
	@Test(priority = 4)
	public void verifyCustomerFieldsTest() {
		
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
	
	

}
