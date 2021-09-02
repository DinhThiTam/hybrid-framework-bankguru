package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.user.nopCommerce.CustomerInfoPageObject;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;
//import reportConfig.ExtentTestManager;

public class Level_13_Register_Login_Log_ExtentReport_V3_V4 extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		
		driver = getBrowserDriver(browserName, appURL);
		emailAddress = getRandomEmail();
		password = "123456";
	}
	@Test
	public void Login_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("User_01_Register - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("User_01_Register - Step 03: Click to Male radio button");
		registerPage.clickToGenderRadioButton();
		
		log.info("User_01_Register - Step 04: Click to First Name textbox");
		registerPage.enterToFirstNameTextbox("dinh");
		
		log.info("User_01_Register - Step 05: Click to Last Name textbox");
		registerPage.enterToLastNameTextbox("tam");
		
		log.info("User_01_Register - Step 06: Click to Email textbox with value: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("User_01_Register - Step 07: Click to Password textbox with value: " + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("User_01_Register - Step 08: Click to Confirm Password textbox with value: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("User_01_Register - Step 09: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register - Step 10: Verify success message is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("User_01_Register - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("User_01_Register - Step 12: Verify  Home Page is displayed ");
		verifyFalse(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		log.info("User_01_Register - Step 01: Click to Login link");
		loginPage= homePage.clickToLoginLink();
		
		log.info("User_01_Register - Step 02: Enter to Email textbox with value: " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("User_01_Register - Step 03: Enter to Password textbox with value: " + password);
		loginPage.enterToPasswordTextbox(password);
		
		log.info("User_01_Register - Step 04: Click to Login button");
		homePage= loginPage.clickToLoginButton();
		
		log.info("User_01_Register - Step 05: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
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
	SearchPageObject searchPage;
	CustomerInfoPageObject customInfoPage;
	OrderPageObject orderPage;
}
