package com.liveguru.login;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;

public class Level_04_Login_Page_Object extends BaseTest{
	WebDriver driver;
	BasePage basePage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
	}

	@Test
	public void Login_01_Empty_Email() {
		driver.get("http://live.demoguru99.com/");
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
//		loginPage.enterToEmailTextbox("");
//		loginPage.enterToPasswordTextbox("");
//		loginPage.clickToLoginButton();
		loginPage.loginToSystem("", "");
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshPage(driver);
//		loginPage.enterToEmailTextbox("123@345.789");
//		loginPage.enterToPasswordTextbox("123456");
//		loginPage.clickToLoginButton();
		loginPage.loginToSystem("123@345.789", "123456");
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {
		loginPage.refreshPage(driver);
//		loginPage.enterToEmailTextbox("dam@gmail.com");
//		loginPage.enterToPasswordTextbox("123");
//		loginPage.clickToLoginButton();
		loginPage.loginToSystem("dam@gmail.com", "123");
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(),"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test(description = "Email not exist in system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshPage(driver);
//		loginPage.enterToEmailTextbox(getRandomEmail());
//		loginPage.enterToPasswordTextbox("123456");
//		loginPage.clickToLoginButton();
		loginPage.loginToSystem(getRandomEmail(), "123456");
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshPage(driver);
//		loginPage.enterToEmailTextbox("dam@gmail.com");
//		loginPage.enterToPasswordTextbox("112233");
//		loginPage.clickToLoginButton();
		loginPage.loginToSystem("dam@gmail.com", "112233");
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshPage(driver);
//		loginPage.enterToEmailTextbox("dam@gmail.com");
//		loginPage.enterToPasswordTextbox("123123");
//		loginPage.clickToLoginButton();
		loginPage.loginToSystem("dam@gmail.com", "123123");
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplay());
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
	MyDashboardPageObject myDashboardPage;

}
