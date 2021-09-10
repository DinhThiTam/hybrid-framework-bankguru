package com.nopcommerce.user;


import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.user.nopCommerce.CustomerInfoPageObject;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_15_Register_Login_PaternObject extends BaseTest{
	WebDriver driver;
	String emailAddress, password, day, month, year;
	String projectLocation = System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '"+ browserName + "' and navigate '" + appURL + "'");
		day ="26";
		month = "May";
		year = "1990";
		driver = getBrowserDriver(browserName, appURL);
		emailAddress = getRandomEmail();
		password = "123456";
	}
//	@Test
//	public void Login_01_Register_To_System() {
//		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//		
//		log.info("User_01_Register - Step 02: Click to Register link");
//		homePage.clickToHeaderLinkByText(driver,"Register");
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//		
//		log.info("User_01_Register - Step 03: Click to Male radio button");
//		registerPage.clickToRadioButtonByID(driver,"gender-female");
//		
//		log.info("User_01_Register - Step 04: Click to First Name textbox");
//		registerPage.enterToTextboxByID(driver,"FirstName", "dinh");
//		
//		log.info("User_01_Register - Step 05: Click to Last Name textbox");
//		registerPage.enterToTextboxByID(driver,"LastName", "tam");
//		
//		log.info("User_01_Register - Step 06: Click to Day dropdown");
//		registerPage.enterToDropdownByName(driver,day, "DateOfBirthDay");
//		
//		log.info("User_01_Register - Step 06: Click to Month dropdown");
//		registerPage.enterToDropdownByName(driver,month, "DateOfBirthMonth");
//		
//		log.info("User_01_Register - Step 07: Click to Year dropdown");
//		registerPage.enterToDropdownByName(driver,year, "DateOfBirthYear");
//		
//		log.info("User_01_Register - Step 08: Click to Email textbox with value: " + emailAddress);
//		registerPage.enterToTextboxByID(driver,"Email", emailAddress);
//		
//		log.info("User_01_Register - Step 09: Click to Password textbox with value: " + password);
//		registerPage.enterToTextboxByID(driver,"Password", password);
//		
//		log.info("User_01_Register - Step 10: Click to Confirm Password textbox with value: " + password);
//		registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);
//		
//		log.info("User_01_Register - Step 11: Click to Register button");
//		registerPage.clickToButtonByText(driver, "Register");
//		
//		log.info("User_01_Register - Step 12: Verify success message is displayed");
//		verifyTrue(registerPage.isSuccessMessageDisplayed());
//		
//		log.info("User_01_Register - Step 13: Click to Logout link");
//		registerPage.clickToHeaderLinkByText(driver,"Log out");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//		log.info("User_01_Register - Step 14: Verify  Home Page is displayed ");
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//	}
//	
//	@Test
//	public void Login_02_Login_To_System() {
//		log.info("User_01_Register - Step 01: Click to Login link");
//		homePage.clickToHeaderLinkByText(driver, "Log in");
//		loginPage = PageGeneratorManager.getLoginPage(driver);
//		log.info("User_01_Register - Step 02: Enter to Email textbox with value: " + emailAddress);
//		registerPage.enterToTextboxByID(driver,"Email", emailAddress);
//		
//		log.info("User_01_Register - Step 03: Enter to Password textbox with value: " + password);
//		registerPage.enterToTextboxByID(driver,"Password", password);
//		
//		log.info("User_01_Register - Step 04: Click to Login button");
//		loginPage.clickToButtonByText(driver, "Log in");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//		log.info("User_01_Register - Step 05: Verify Home Page is displayed");
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//	}
	
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun=true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition - Close Browser - " + browserName + "");
		cleanBrowserAndDriver();
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		rand.nextInt(99999);
		return "testing" + rand.nextInt(99999) + "@email.com";
	}
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	CustomerInfoPageObject customInfoPage;
	OrderPageObject orderPage;
}
