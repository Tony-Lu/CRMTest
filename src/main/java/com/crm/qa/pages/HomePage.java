package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardMenu;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement adminMenu;
	
	@FindBy(id = "welcome")
	WebElement welcomeAdminLink;
	
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PIMTab;
	
	@FindBy(id = "menu_pim_Configuration")
	WebElement configurationTab;
	
	@FindBy(xpath = "//a[text()='Custom Fields']")
	WebElement customerFieldsTab;
	
//	@FindBy(id = "menu_admin_UserManagement")
//	WebElement userManageTab;
//	
//	@FindBy(id = "menu_admin_Job")
//	WebElement jobTab;
//	
//	@FindBy(id = "menu_admin_Organization")
//	WebElement organizationTab;
	
	public HomePage() {		
		PageFactory.initElements(driver, this);
	}
	
	//Action 1:
	public String validateHomePageTitle() {
		return driver.getTitle();		
	}
	
	//Action 2:
	public boolean verifyWelcomAdminLink() {
		return welcomeAdminLink.isDisplayed();
		
	}
	
	//Action 3:
	public boolean validateDashboardWebElement() {
		return dashboardMenu.isDisplayed();		
	}
	
	//Action 4:
	public AdminPage clickAdminMenu() {
		adminMenu.click();
		return new AdminPage();
	}
	
	
	public PIMPage clickPIMTab() {
		PIMTab.click();
		return new PIMPage();
	}
	
	//need mouse over action
	public void clickPIMConfiguration() {
		Actions action = new Actions(driver);
		action.moveToElement(configurationTab).build().perform();
		customerFieldsTab.click();
		
	}
	


}
