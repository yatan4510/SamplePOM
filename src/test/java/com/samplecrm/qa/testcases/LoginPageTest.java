package com.samplecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//git check
import com.samplecrm.qa.base.TestBase;
import com.samplecrm.qa.pages.HomePage;
import com.samplecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
//	public LoginPageTest() {
//		super();
//	}
	
	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginPage=new LoginPage();
	}
	
	@Test
	public void ImageTest() {
		boolean b =loginPage.getImage();
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void TitleTest() {
		String title=loginPage.getTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}
	
	@Test
	public void loginTest() {
	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
