package com.crm.qa.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.resources.Base;
import com.crm.qa.utils.TestUtils;

public class ContactsPageTest extends Base {

	ContactsPageTest contactsPageTest;

	LoginPage loginpage;

	HomePage homepage;

	ContactsPage contacts;

	TestUtils testUtils;

	public ContactsPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void initialization() throws Exception {

		setup();

		contactsPageTest = new ContactsPageTest();

		loginpage = new LoginPage();

		homepage = new HomePage();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		contacts = new ContactsPage();

		testUtils = new TestUtils();

		testUtils.switchToFrame();

		contacts = homepage.clickOnContactModule();

	}

	@Test(priority = 1)
	public void verifyContactsPageisDisplayed() throws Exception {

		Assert.assertTrue(contacts.contactsLabelIsDisplayed(), "Contacts page is not displayed");
	}

	@Test(priority = 2)
	public void clickOnCheckbox() throws InterruptedException {

		contacts.clickOnCheckbox("Aksh Yadav");
	}

	@Test(priority = 3)
	public void validateCreateNewContact() {

		driver.navigate().refresh();
		testUtils.switchToFrame();
		homepage.clickonNewContactlink();
		contacts.createNewContact("Sir", "Demo", "1", "DemoCompany.");

	}
	
//	@Test(priority = 4, dataProvider = "getDataForContactCreation")
//	public void validateMutipleCreateNewContact(String title, String name, String surname, String company) throws Exception {
//		
//		driver.navigate().refresh();
//		testUtils.switchToFrame();
//		homepage.clickonNewContactlink();
//		contacts.createNewContact(title, name, surname, company);
//	}
	
//	@DataProvider
//	public Object[][] getDataForContactCreation() throws Exception {
//		
//		Object[][] data = testUtils.getData("contacts");
//		return data;
//	}
	

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
