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
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageUIs.nopCommerce.RegisterPageUI;

public class Practice_TC_03_MyAccount extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	BasePage basePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		emailAddress = getRandomEmail();
		password = "123456";
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Customer_Info() {
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.registerToSystem(emailAddress, password, password, "dinh", "tam");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.refreshPage(driver);
		loginPage.loginToSystem(emailAddress, password);
		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountLink();
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.clickToCustomerInfoLink();
		registerPage = new RegisterPageObject(driver);
		// registerPage.clearAllTextbox();

		registerPage.clickToGenderFemaleRadioButton();
		registerPage.enterToFirstNameTextbox("Automation");
		registerPage.enterToLastNameTextbox("FC");
		
		registerPage.selectToBirthdayDropDown("1");
		registerPage.selectToBirthmonthDropDown("January");
		registerPage.selectToBirthyearDropDown("1999");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToCompanyNameTextbox("Automation FC");
		registerPage.clickToSaveButton();

		Assert.assertEquals(registerPage.getFirstNameTextbox(), "Automation");
		Assert.assertEquals(registerPage.getLastNameTextbox(), "FC");
		Assert.assertEquals(registerPage.getSelectedBirthdayDropdown(), "1");
		Assert.assertEquals(registerPage.getSelectedBirthmonthDropdown(), "January");
		Assert.assertEquals(registerPage.getSelectedBirthyearDropdown(), "1999");
		Assert.assertEquals(registerPage.getEmailTextbox(), emailAddress);
		Assert.assertEquals(registerPage.getCompanyNameTextbox(), "Automation FC");
	}

	@Test
	public void TC_02_Address() {

	}

	@Test
	public void TC_03_Change_Password() {

	}

	@Test
	public void TC_04_My_Product_View() {

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
	MyAccountPageObject myAccountPage;
}
