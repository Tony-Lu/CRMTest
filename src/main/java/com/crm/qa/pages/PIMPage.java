package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class PIMPage extends TestBase {

	@FindBy(id = "customField_name")
	WebElement inputFieldName;

	@FindBy(id = "menu_pim_Configuration")
	//@CacheLookup  ---- this is for RAM use, improve script performance
	WebElement configurationTab;

	@FindBy(xpath = "//option[text()='Dependents']")
	WebElement screenSelect;

	@FindBy(xpath = "//a[text()='Custom Fields']")
	WebElement customerFieldsTab;

	@FindBy(id = "customField_type")
	WebElement typeSelect;

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PIMTab;


	public PIMPage() {		
		PageFactory.initElements(driver, this);
	}

	//Action 1:
	public void verifyconfigurationTab() {
		configurationTab.click();

	}

	//need mouse over action - 2
	public void clickPIMConfiguration() {
		Actions action = new Actions(driver);
		action.moveToElement(configurationTab).build().perform();
		customerFieldsTab.click();
	}

	//Action 3:
	public void verifyInputFieldName(String fieldVal) {
		inputFieldName.sendKeys(fieldVal);


	}

	//Action 4:
	public void selectScreenValByName(String text) {
		Select select = new Select(driver.findElement(By.xpath("//option[text()='"+text+"']")));
		select.selectByVisibleText(text);
	}





}
