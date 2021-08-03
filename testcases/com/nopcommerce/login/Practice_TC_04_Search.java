package com.nopcommerce.login;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.AddressPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.ProductReviewPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

public class Practice_TC_04_Search extends BaseTest {
	WebDriver driver;
	String emailAddress, password, newPassword, birthDay, birthMonth, birthYear, firstName, lastName, fullName, citySateZip,companyName, stateProvince, countryName, cityName, address1, address2, zipCode, phoneNumber, faxNumber;
	String projectLocation = System.getProperty("user.dir");
	BasePage basePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		emailAddress = getRandomEmail();
		password = "123456";
		newPassword = "1234567";
		birthDay = "1";
		birthMonth = "January";
		birthYear = "1999";
		firstName= "Automation" ; 
		lastName= "FC"; 
		fullName = firstName + " " + lastName;
		companyName= "Automation FC";
		stateProvince= "Other"; 
		countryName="Viet Nam" ;
		cityName= "Da Nang";
		address1="123/04 Le Lai" ;
		address2= "234/05 Hai Phong"; 
		zipCode= "550000"; 
		citySateZip = cityName + ", " + zipCode;
		phoneNumber= "0123456789"; 
		faxNumber = "0983970447";
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Empty_Data() {
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		registerPage.registerToSystem(emailAddress, password, password, firstName, lastName);
		
		registerPage.clickToSearchFooterLink();
		searchPage = new SearchPageObject(driver);
		searchPage.enterSearchKeywordTextbox("");
		searchPage.clickToSearchButton();
		
		
	}

	@Test
	public void TC_02_Data_Not_Exist() {
		
	}
	
	@Test
	public void TC_03_Product_Name_Relative() {
	
	}

	@Test
	public void TC_04_Product_Name_Absolute() {
		
	}
	
	@Test
	public void TC_05_Parent_Categories() {
		
	}
	
	@Test
	public void TC_06_Product_Sub_Categories() {
		
	}
	
	@Test
	public void TC_07_Incorrect_Manufactuner() {
		
	}
	
	@Test
	public void TC_08_Correct_Manufactuner() {
		
	}
	
	@Test
	public void TC_09_Price_Range() {
		
	}
	
	
	@Test
	public void TC_10_Price_Range_Less_Than_Product_Range() {
		
	}
	
	@Test
	public void TC_11_Price_Range_More_Than_Product_Range() {
		
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
	AddressPageObject addressPage;
	ChangePasswordPageObject changePasswordPage;
	ProductReviewPageObject reviewPage;
	SearchPageObject searchPage;
}
