package hashMapTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class hashMapTest extends TestBase {

	String Credentials;
	String CredentialsInfo[];
		//WebDriverManager.chromedriver().setup(); 

		// adding browser version: WebDriverManager.chromedriver().version("2.36").setup();
		
	@BeforeMethod
	public void setUp() {
	driver = new ChromeDriver();			

		driver.manage().window().maximize();
		/////////driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
	}
	
	@Test(priority=1)
	public void loginWithAdmin1Test() {
		Credentials = hashMapData.getUserLoginInfo().get("1stAdmin");
		CredentialsInfo = Credentials.split("_");
		
		driver.findElement(By.id("txtUsername")).sendKeys(CredentialsInfo[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(CredentialsInfo[1]);
		
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals(false, true);
		
	}
	
	@Test(priority=2)
	public void loginWithAdmin2Test() {
		Credentials = hashMapData.getUserLoginInfo().get("2ndAdmin");
		CredentialsInfo = Credentials.split("_");
		
		driver.findElement(By.id("txtUsername")).sendKeys(CredentialsInfo[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(CredentialsInfo[1]);
		
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
