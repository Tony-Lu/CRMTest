package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;
import com.crm.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class youtubeVideoSikuli extends TestBase {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		WebDriverManager.chromedriver().setup();

		// adding browser version:
		// WebDriverManager.chromedriver().version("2.36").setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		///////// driver.manage().deleteAllCookies();
		// below is : dynamic wait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/watch?v=qvE2miLMbNk");

		Thread.sleep(7000);
		try {
			driver.findElement(By.xpath("//button[@class='ytp-ad-skip-button ytp-button']")).click();
		} catch (Exception e) {
			Thread.sleep(1000);
		}

		// create the obj of Screen class -- from sikuli:
		Screen s = new Screen();

		// pause icon:
		Pattern pauseImg = new Pattern("temp.PNG");
		s.wait(pauseImg, 2000);
		s.click();

		// play icon:
		Pattern playImg = new Pattern("play.PNG");
		s.wait(playImg, 2000);
		s.click();

		// setting icon:
		Pattern settingImg = new Pattern("setting.PNG");
		s.wait(settingImg, 2000);
		s.click();

		// 480p icon:
		Pattern firstSettingValImg = new Pattern("480.PNG");
		s.wait(firstSettingValImg, 2000);
		s.click();		

		// 360 icon:
		Pattern secondSettingValImg = new Pattern("360.PNG");
		s.wait(secondSettingValImg, 2000);
		s.click();

	}

}
