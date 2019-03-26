package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AdminPage extends TestBase {
	
	@FindBy(id="btnAdd")
	WebElement btnAdd;
	
	@FindBy(id="ohrmList_chkSelectRecord_6")
	WebElement checkBox1;
	
	
	// Initializing the Page objects:
	public AdminPage() {
			
		PageFactory.initElements(driver, this);
	}
	
	//Action 1:
	public boolean verifyAddButton() {
		return btnAdd.isDisplayed();
			
	}
	
	//Action 2: // this is a checkBox: below xpath get by Katalon plugin in Firefox
	// xpath: (.//*[normalize-space(text()) and normalize-space(.)='fiona.grace'])[1]/preceding::input[1]
	// xpath: (.//*[normalize-space(text()) and normalize-space(.)='hannah.flores'])[1]/preceding::input[1]
	// 
	public void selectCheckBox1ByName(String name) {
//		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)="+name+"])[1]/preceding::input[1]")).click();
		// below xpath is written as per syntax
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='left']//preceding-sibling::td//input[@name='chkSelectRow[]']")).click();
	}
	
	
	

}
