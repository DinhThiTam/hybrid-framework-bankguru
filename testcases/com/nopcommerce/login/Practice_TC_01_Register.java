package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageUIs.nopCommerce.RegisterPageUI;

public class Practice_TC_01_Register extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	BasePage basePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		emailAddress = getRandomEmail();
		password = "123456";
		driver.manage().window().maximize();	
	}
	
	@Test
	public void Register_01_Empty_Data() {
		//driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterButton();	
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.FIRSTNAME_EMPTY_MESSAGE));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.LASTNAME_EMPTY_MESSAGE));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.EMAIL_EMPTY_MESSAGE));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.PASSWORD_EMPTY_MESSAGE));
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_MESSAGE));
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		registerPage.refreshPage(driver);
		registerPage.enterToFirstNameTextbox("dinh");
		registerPage.enterToLastNameTextbox("tam");
		registerPage.enterToEmailTextbox("abc@123.456");
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();	
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.EMAIL_INVALID_MESSAGE));
	}
	
	@Test
	public void Register_03_Exist_Email() {
		registerPage.refreshPage(driver);
		registerPage.enterToFirstNameTextbox("dinh");
		registerPage.enterToLastNameTextbox("tam");
		registerPage.enterToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();	
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.EMAIL_EXIST_MESSAGE));
	}
	
	@Test(description = "Password less than 6 chars")
	public void Register_04_Valid_Password() {
		registerPage.refreshPage(driver);
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("dinh");
		registerPage.enterToLastNameTextbox("tam");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123");
		registerPage.clickToRegisterButton();	
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.PASSWORD_INVALID_MESSAGE));
	}
	
	@Test
	public void Register_05_Not_Match_Password() {
		registerPage.refreshPage(driver);
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("dinh");
		registerPage.enterToLastNameTextbox("tam");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_INVALID_MESSAGE));
	}
	@Test
	public void Register_06_Valid_Infomation() {
		registerPage.refreshPage(driver);
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("dinh");
		registerPage.enterToLastNameTextbox("tam");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);	
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
