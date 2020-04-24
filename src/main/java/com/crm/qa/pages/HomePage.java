package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.resources.Base;

public class HomePage extends Base {

	public HomePage() throws Exception {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement username;

	@FindBy(xpath = "//ul[@class = 'mlddm']/li/a")
	List<WebElement> modulesName;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	// Actions

	public String getUsername() {

		return username.getText();
	}

	public List<String> getModulesName() {

		List<String> allModules = new ArrayList<String>();

		for (int i = 0; i < modulesName.size(); i++) {

			allModules.add(modulesName.get(i).getText());
		}

		// System.out.println("Modules displayed in System are: " + allModules);

		return allModules;
	}

	public ContactsPage clickOnContactModule() throws Exception {

		contactsLink.click();

		return new ContactsPage();
	}

	public void clickonNewContactlink() {

//		Actions action = new Actions(driver);
//		Thread.sleep(3000);
//		action.moveToElement(Contacts).build().perform();
//		
//	    WebElement contact = driver.findElement(By.xpath("//a[text() = 'Contacts']"));
//		WebElement newContact = driver.findElement(By.xpath("//a[text() = 'New Contact']"));
//		Actions action = new Actions(driver);
//		action.moveToElement(contact).build().perform();
//		newContact.click();

		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();

	}
}
