package com.samplecrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samplecrm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement crmLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContacts;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUser() {
		return usernameLabel.isDisplayed();
		
	}
	
	public boolean verifyCRMImage() {
		
		return crmLabel.isDisplayed();
		
	}
	
	public ContactsPage clickContactsLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	public void clickOnNewContacts() {
		
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", newContacts);
		System.out.println("hogya");
	}
	
}
