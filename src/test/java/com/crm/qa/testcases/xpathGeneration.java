package com.crm.qa.testcases;

import org.openqa.selenium.By;

public class xpathGeneration {

	// input[@id='test'] ====== here single quote ' , or double quote " , both are
	// okay
	// here 'test' will change during runtime, changed to below:
	// input[@id='{0}']
	
	// * sometimes we need more than 2 locator in xpath:
	// input[@id='{0}' and @name='{1}']
	
	// below preceding-sibling: is going up to upper html line:
	//a[text()='JMorgan']//parent::td[@class='left']//preceding-sibling::td//input[@type='checkbox']
	
	// below following-sibling: is going down to next html line:
	//a[text()='JMorgan']//parent::td[@class='left']//following-sibling::td//input[@type='checkbox']
	// below is list all the "li"s from parent "ul" html:
	//ul[contains(@class, 'multiselect-container dropdown-menu')]//li//a//label"
	
	public static By email = By.xpath(createXpath("// input[@id='{0}']", "test@mail.com")); 
	// here is the key point, before run, we need know
	
	
	
	public static String createXpath(String xpathExp, Object... args) { // here "args" is an array data type
		for (int i = 0; i < args.length; i++) {
			xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
		}
		return xpathExp;
	}

	public static void main(String[] args) {

		String x1 =  createXpath("// input[@id='{0}']", "test");  // here value "test" may got from any API/excel
		System.out.println(x1);
		
		// below is for 2+ parameter in xpath:
		String x2 = createXpath("// input[@id='{0}' and @name='{1}']", "email", "username");
		System.out.println(x2);
		
		// below will get runtime xpath value
		System.out.println(email.toString().substring(email.toString().indexOf("//")));

	}

}
