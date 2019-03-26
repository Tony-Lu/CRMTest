package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class elementVisibilityTest extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		// adding browser version:
		// WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		///////// driver.manage().deleteAllCookies();
		// below is : dynamic wait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/register/");

		// isDisplayed() method: applicable for all the elements
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b1);

		// 2. isEnabled() method:
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);

		// select I agree checkbox:
		driver.findElement(By.name("agreeTerms")).click();
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b3);

		// 3. isSelected() method: only applicable for checkbox, dropdown, radiobutton
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4);

		// deselect I agree checkbox:
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.id("submitButton")).isSelected();
		System.out.println(b5);

	}

}
