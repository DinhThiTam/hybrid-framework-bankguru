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
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage= homePage.clickToRegisterLink();
		registerPage.registerToSystem("", "", "", "", "");
		Assert.assertTrue(registerPage.isFirstnameEmptyInvalidMessageDisplayed());
		Assert.assertTrue(registerPage.isLastnameEmptyInvalidMessageDisplayed());
		Assert.assertTrue(registerPage.isEmailEmptyMessageDisplayed());
		Assert.assertTrue(registerPage.isPasswordEmptyInvalidMessageDisplayed());
		Assert.assertTrue(registerPage.isConfirmPasswordEmptyInvalidMessageDisplayed());
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		registerPage.registerToSystem("abc@123.456", password, password, "dinh", "tam");	
		Assert.assertTrue(registerPage.isEmailInvalidMessageDisplayed());
	}
	
	@Test
	public void Register_04_Exist_Email() {
		registerPage.registerToSystem(emailAddress, password, password, "dinh", "tam");	
		Assert.assertTrue(registerPage.isEmailExistMessageDisplayed());
	}
	
	@Test(description = "Password less than 6 chars")
	public void Register_05_InValid_Password() {
		registerPage.registerToSystem(emailAddress, "123", "", "dinh", "tam");	
		Assert.assertTrue(registerPage.isPasswordInvalidMessageDisplayed());
	}
	
	@Test
	public void Register_06_Not_Match_Password() {
		registerPage.registerToSystem(emailAddress, password, "123", "dinh", "tam");
		Assert.assertTrue(registerPage.isConfirmPasswordInvalidMessageDisplayed());
	}
	@Test
	public void Register_03_Valid_Infomation() {
		registerPage.registerToSystem(emailAddress, password, password, "dinh", "tam");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
		homePage.clickToRegisterLink();
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
