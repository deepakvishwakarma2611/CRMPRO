package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.resources.Base;

public class LoginPage extends Base {
	


	@FindBy(xpath = "//input[@name= 'username']")
	WebElement username;

	@FindBy(xpath = "//input[@name= 'password']")
	WebElement password;

	@FindBy(xpath = "//input[@value= 'Login']")
	WebElement loginButton;

	@FindBy(xpath = "//img[@src= 'https://classic.freecrm.com/img/logo.png']")
	WebElement logo;

	// Initialize the Page Objects
	public LoginPage() throws Exception {

		PageFactory.initElements(driver, this);

	}


	// Actions

	public String verifyTitle() {

		return driver.getTitle();
	}

	public boolean verifyLogo() {

		return logo.isDisplayed();
	}

	public HomePage login(String un, String pw) throws Exception {

		username.sendKeys(prop.getProperty("username"));

		password.sendKeys(prop.getProperty("password"));

		loginButton.click();

		return new HomePage();
	}

}
