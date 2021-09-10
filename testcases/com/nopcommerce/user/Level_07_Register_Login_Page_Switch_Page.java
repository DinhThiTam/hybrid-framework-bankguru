package com.nopcommerce.user;

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
import pageObjects.user.nopCommerce.CustomerInfoPageObject;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_07_Register_Login_Page_Switch_Page extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		emailAddress = getRandomEmail();
		password = "123456";
		driver.manage().window().maximize();	
	}
	@Test
	public void Login_01_Register_To_System() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("dinh");
		registerPage.enterToLastNameTextbox("tam");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void Login_02_Login_To_System() {
		loginPage= homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage= loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_03_Open_Page_At_Footer() {
		//Home -> Search
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		//Search -> My account
		customInfoPage = (CustomerInfoPageObject) searchPage.getFooterPageByName(driver, "My account");
		//My account -> Order
		orderPage = (OrderPageObject) customInfoPage.getFooterPageByName(driver, "Order");
		
		//Order -> My account
		customInfoPage = (CustomerInfoPageObject) orderPage.getFooterPageByName(driver, "My account");
		//My acc -> Search
		searchPage = (SearchPageObject) customInfoPage.getFooterPageByName(driver, "Search");
		
		//Search -> Order
		orderPage = (OrderPageObject) searchPage.getFooterPageByName(driver, "Order");
	}
//	@Test
//	public void Login_04_Open_Page_At_Footer() {
//		
//		//Order -> My account
//		orderPage.openFooterPageByName(driver, "My account");
//		customInfoPage = PageGeneratorManager.getCustomInfoPage(driver);
//		
//		//My acc -> Search
//		customInfoPage.openFooterPageByName(driver, "Search");
//		searchPage = PageGeneratorManager.getSearchPage(driver);
//		//Search -> Order
//		
//		searchPage.openFooterPageByName(driver, "Search");
//		orderPage = PageGeneratorManager.getOrderPage(driver);
//	}
	
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
