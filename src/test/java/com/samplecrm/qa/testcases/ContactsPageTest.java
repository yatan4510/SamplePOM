package com.samplecrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samplecrm.qa.base.TestBase;
import com.samplecrm.qa.pages.ContactsPage;
import com.samplecrm.qa.pages.HomePage;
import com.samplecrm.qa.pages.LoginPage;
import com.samplecrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactpage;
	TestUtil testUtil;
	String sheetName = "TestData";

	@BeforeMethod
	public void setup() {
		Initialization();
		loginPage = new LoginPage();
		contactpage=new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");
		contactpage = homePage.clickContactsLink();
	}

	@Test
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactpage.verifyContactsPage(), "contacts label is missing on the page");
	}

	@Test
	public void selectSingleContactsTest() {
		contactpage.selectContacts("Divya Dutta");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws EncryptedDocumentException, IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void addContact(String title, String fname, String lname, String company) {
		driver.switchTo().defaultContent();
		System.out.println("Default");
		testUtil.switchToFrame("mainpanel");
		System.out.println("Main");

		homePage.clickOnNewContacts();
		//contactpage.addNewContact("Mr.", "Peter", "Parker", "Sony");
		contactpage.addNewContact(title,fname,lname,company);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
