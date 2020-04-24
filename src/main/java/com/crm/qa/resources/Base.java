package com.crm.qa.resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.WebEventListener;

public class Base {
	
	EventFiringWebDriver edriver;
	
	WebEventListener eventListener;
	
	public static Properties prop;

	public static WebDriver driver;

	public Base() throws Exception {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");

		prop.load(fis);

	}

	public void setup() throws Exception {

		String browserName = prop.getProperty("browser");

		if (browserName.contentEquals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else {

			System.out.println("You have no other driver");
		}
		
		edriver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		
		edriver.register(eventListener);
		
		driver = edriver;
		
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
