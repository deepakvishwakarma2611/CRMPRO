package com.crm.qa.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.resources.Base;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends Base {

	HomePageTest homePageTest;

	LoginPage loginPage;

	HomePage homePage;

	ContactsPage contacts;

	TestUtils testUtils;

	public HomePageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void Initialization() throws Exception {

		setup();

		homePageTest = new HomePageTest();

		loginPage = new LoginPage();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		testUtils = new TestUtils();

		contacts = new ContactsPage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {

		String homePageTitle = driver.getTitle();

		Assert.assertEquals(homePageTitle, "CRMPRO", "Title does not match");

	}

	@Test(priority = 2)
	public void verifyUsernameTest() {

		testUtils.switchToFrame();

		String username = homePage.getUsername();

		System.out.println(username);

		username = username.trim();

		System.out.println(username);

		Assert.assertEquals(username, "User: Demo User", "Username does not match");
	}

	@Test(priority = 3)
	public void verifyModulesNameTest() {

		testUtils.switchToFrame();
		System.out.println(homePage.getModulesName());

		List<String> expectedModulesName = new ArrayList<String>();
		expectedModulesName.add("HOME");
		expectedModulesName.add("CALENDAR");
		expectedModulesName.add("COMPANIES");
		expectedModulesName.add("CONTACTS");
		expectedModulesName.add("DEALS");
		expectedModulesName.add("TASKS");
		expectedModulesName.add("CASES");
		expectedModulesName.add("CALL");
		expectedModulesName.add("EMAIL");
		expectedModulesName.add("TEXT/SMS");
		expectedModulesName.add("PRINT");
		expectedModulesName.add("CAMPAIGNS");
		expectedModulesName.add("DOCS");
		expectedModulesName.add("FORMS");
		expectedModulesName.add("REPORTS");

		System.out.println(expectedModulesName);

		Assert.assertEquals(homePage.getModulesName(), expectedModulesName, "Modules name does not match");

	}

	@Test(priority = 4)
	public void verifyContactsLinkTest() throws Exception {

		testUtils.switchToFrame();

		contacts = homePage.clickOnContactModule();

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
