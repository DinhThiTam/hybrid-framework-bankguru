package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_04_Register_Login_Page_Object {
	WebDriver driver;
	String username, password;
	String projectLocation = System.getProperty("user.dir");
	BasePage basePage;
	
	@BeforeClass
	public void initBrowser() {
	System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@Test
	public void Login_01_Register_To_System() {
		driver.get("https://www.nopcommerce.com/");
		homePage = new HomePageObject();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject();
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject();	
	}
	
	@Test
	public void Login_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject();
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginButton();
		homePage = new HomePageObject();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed);
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
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
