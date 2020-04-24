package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.resources.Base;

public class ContactsPage extends Base {
	
	//public static WebDriverWait wait;
	
	public ContactsPage() throws Exception {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
//	@FindBy(xpath = "//a[text() = 'apple pie']/preceding:: td[1]")
//	WebElement checkBox;
	
	@FindBy(xpath = "//select[@name = 'title']")
	WebElement titleDropdown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	//Actions
	public boolean contactsLabelIsDisplayed() {
		
		return contactsLabel.isDisplayed();
	}
	
	public WebElement clickOnCheckbox(String name) {
		
		return driver.findElement(By.xpath("//a[text() = '"+name+"']/preceding:: td[1]"));
		
	} 
	
	public void createNewContact(String title, String ftName, String ltName, String comp){
		
		//wait = new WebDriverWait(driver, 20);
		
		Select select = new Select(driver.findElement(By.name("title")));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("title"))));
		select.selectByVisibleText(title);
		
		//wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(ftName);
		
		//wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(ltName);
		
		//wait.until(ExpectedConditions.elementToBeClickable(company));
		company.sendKeys(comp);
		
		//wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	
	}
	
	
}
