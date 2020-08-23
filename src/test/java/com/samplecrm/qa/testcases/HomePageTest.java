package com.samplecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.samplecrm.qa.base.TestBase;
import com.samplecrm.qa.pages.ContactsPage;
import com.samplecrm.qa.pages.HomePage;
import com.samplecrm.qa.pages.LoginPage;
import com.samplecrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactpage;
	TestUtil testUtil;

	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginPage =new LoginPage();
		testUtil=new TestUtil();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyUserTest() {
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUser(), "Username is missing");
	}
	
	@Test
	public void verifyCRMImageTest() {
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyCRMImage(), "Username is missing");
	}
	
	@Test
	public void clickContactsLinkTest() {
		testUtil.switchToFrame("mainpanel");
		contactpage=homePage.clickContactsLink();
		
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
