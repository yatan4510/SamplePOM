package com.samplecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.samplecrm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath = "//form[@id='contactForm']//input[@value='Save']")
	WebElement saveButton;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPage() {
		return contactsLabel.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("(//a[@_name='" + name + "'])[1]/parent::td/preceding-sibling::td/input")).click();
	}

	public void addNewContact(String title, String fname, String lname, String company) {

		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);

		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		this.company.sendKeys(company);
		saveButton.click();
	}

}
