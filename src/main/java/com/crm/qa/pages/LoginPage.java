package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - Object Repository:
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	//@FindBy(xpath="//button[contains(test(), 'Sign Up']") == create dynamic xpath to catch the obj
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	WebElement crmLogo;
	
	// Initializing the Page objects:
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();		
	}
	
	public boolean validateCRMLogo() {		
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String psw) {
		username.sendKeys(un);
		password.sendKeys(psw);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	

}
