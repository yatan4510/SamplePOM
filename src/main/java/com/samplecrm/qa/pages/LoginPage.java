package com.samplecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samplecrm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement Login;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement image;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		
		return driver.getTitle();
		
	}
	public boolean getImage() {
		
		return image.isDisplayed();
	}
	public HomePage login(String username, String pwd) {
		
		
		this.username.sendKeys(username);
		password.sendKeys(pwd);
		Login.click();
		return new HomePage();
		
		
	}
}
