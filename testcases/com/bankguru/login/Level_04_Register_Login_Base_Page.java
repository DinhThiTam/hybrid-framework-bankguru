package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_04_Register_Login_Base_Page extends BasePage {
	WebDriver driver;
	String username, password, loginPageUrl, email;
	String projectLocation = System.getProperty("user.dir");
	BasePage basePage;
	
	@BeforeClass
	public void initBrowser() {
	System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/v4/index.php");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	loginPageUrl = driver.getCurrentUrl();

	}
	@Test
	public void Login_01_Register_To_System() {
		
		clickToElement(driver, "//a[text()='here']");
		senkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		
		username = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}
	
	@Test
	public void Login_02_Login_To_System() {
		driver.get(loginPageUrl);
		getPageURL(driver);
		senkeyToElement(driver, "//input[@name='uid']", username);
		senkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");	
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
		
		
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		rand.nextInt(99999);
		return "testing" + rand.nextInt(99999) + "@email.com";
	}
}
