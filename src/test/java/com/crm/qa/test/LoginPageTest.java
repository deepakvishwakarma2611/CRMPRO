package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.resources.Base;

public class LoginPageTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	
	

	public LoginPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void intialization() throws Exception {

		setup();
		
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() throws Exception {
		
		String title = loginPage.verifyTitle();
		
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.","Title does not match");
		
	}
	
	@Test(priority = 2)
	public void crmLogoIsDisplayed() {
		
		boolean status = loginPage.verifyLogo();
		
		Assert.assertTrue(status);
	}
	
	@Test(priority = 3)
	public void loginTest() throws Exception {
		
		 homePage = loginPage.login(prop.getProperty("username"), "password");
	}
	

	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
