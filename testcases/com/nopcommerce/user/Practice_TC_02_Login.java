package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;


public class Practice_TC_02_Login extends BaseTest {
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
	public void Login_01_Login_Empty_Data() {
		homePage = new HomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToSystem("", password);
		Assert.assertTrue(loginPage.isEmailEmptyMessageDisplay());
	}
	
	@Test
	public void Login_02_Login_Invalid_Email() {
		loginPage.loginToSystem("123", password);
		Assert.assertTrue(loginPage.isEmailInvalidMessageDisplay());
	}
	
	@Test
	public void Login_03_Login_Not_Register_Email() {
		loginPage.loginToSystem("abc@mail.vn", password);
		loginPage.enterToEmailTextbox(getRandomEmail());
		Assert.assertTrue(loginPage.isEmailNotRegisterMessageDisplay());
	}
	@Test
	public void Login_04_Register_Success() {
		homePage = new HomePageObject(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.registerToSystem(emailAddress, password, password, "dinh", "tam");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
	}
	@Test
	public void Login_05_Empty_Password() {
		loginPage.loginToSystem(emailAddress, "");
		Assert.assertTrue(loginPage.isPasswordEmptyMessageDisplay());
	}
	
	@Test
	public void Login_06_Login_Invalid_Password() {
		loginPage.loginToSystem(emailAddress, "123");
		Assert.assertTrue(loginPage.isPasswordInvalidMessageDisplay());
	}
	
	@Test
	public void Login_07_Login_Success() {
		homePage = loginPage.loginToSystem(emailAddress, password);
		Assert.assertTrue(homePage.isLogoutLinkDisplay());
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
