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

public class Level_11_Register_Element_Undisplayed extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
	}
	
	@Test
	public void Register_01_Element_Displayed() {
		registerPage.enterToEmailTexbox("dam@gmail.com");
		registerPage.sleepInsecond(3);
		Assert.assertTrue(registerPage.isConfirmEmailTexboxDisplayed());
	}
	
	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.enterToEmailTexbox("");
		registerPage.sleepInsecond(3);
		Assert.assertFalse(registerPage.isConfirmEmailTexboxDisplayed());
	
	}
	
	@Test
	public void Register_03_Element_Undisplayed_Not_In_DOM() {
		//Wait maximum timeout implicit
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
		
		//Phủ định
		
	}
	
	@Test
	public void Register_04_Element_Undisplayed_Not_In_DOM() {
		//findElemnts để giải quyết timeout maximum
		//overide implicit timeout
		//Khẳng định
		
		Assert.assertTrue(registerPage.isLoginButtonUnDisplayed());
		
		//override timeout
	}
	
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	

}
