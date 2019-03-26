package com.crm.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bootstrapDropBoxHandle extends TestBase {

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
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();

		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container dropdown-menu')]//li//a//label"));

		System.out.println(list.size());

		// select "Augular" checkbox:
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Angular")) {
				list.get(i).click();
				break;
			}
		}

		// select all checkbox:
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			list.get(i).click();

		}

	}

}
