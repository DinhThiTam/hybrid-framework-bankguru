package com.facebook.register;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.faceBook.PageGeneratorManager;
import pageObjects.faceBook.RegisterPageObject;

public class Level_12_Register_Login_Assert_Verify extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
	}
	
	@Test
	public void Register_01_Verify() {
		//Fail 1
		verifyFalse(registerPage.isEmailTexboxDisplayed());
		registerPage.enterToEmailTexbox("dam@gmail.com");
		registerPage.sleepInsecond(3);
		//Failed 2
		verifyFalse(registerPage.isConfirmEmailTexboxDisplayed());
		registerPage.enterToEmailTexbox("");
		registerPage.sleepInsecond(3);
		//Failed 3
		
		verifyTrue(registerPage.isConfirmEmailTexboxDisplayed());
		verifyFalse(registerPage.isLoginButtonDisplayed());
		verifyTrue(registerPage.isLoginButtonUnDisplayed());
	}
	
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	

}
