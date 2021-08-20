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
import pageObjects.user.nopCommerce.AddressPageObject;
import pageObjects.user.nopCommerce.ChangePasswordPageObject;
import pageObjects.user.nopCommerce.CustomerInfoPageObject;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.ProductReviewPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Practice_TC_03_MyAccount extends BaseTest {
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
	public void TC_01_Customer_Info() {
		homePage = new HomePageObject(driver);
		registerPage=homePage.clickToRegisterLink();
		registerPage.registerToSystem(emailAddress, password, password, "dinh", "tam");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		homePage = new HomePageObject(driver);
		customerInfoPage = homePage.clickToMyAccountLink();
		registerPage= customerInfoPage.clickToCustomerInfoLink();

		registerPage.customerInfo(firstName, lastName, birthDay, birthMonth, birthYear, emailAddress, companyName);
		
		Assert.assertEquals(registerPage.getFirstNameTextbox(), firstName);
		Assert.assertEquals(registerPage.getLastNameTextbox(), lastName);
		Assert.assertEquals(registerPage.getSelectedBirthdayDropdown(), birthDay);
		Assert.assertEquals(registerPage.getSelectedBirthmonthDropdown(), birthMonth);
		Assert.assertEquals(registerPage.getSelectedBirthyearDropdown(), birthYear);
		Assert.assertEquals(registerPage.getEmailTextbox(), emailAddress);
		Assert.assertEquals(registerPage.getCompanyNameTextbox(), companyName);
	}

	@Test
	public void TC_02_Address() {
		customerInfoPage = new CustomerInfoPageObject(driver);
		addressPage = customerInfoPage.clickToAddressLink();
		addressPage.clickToAddNewLink();
		
		addressPage.addNewAddress(firstName, lastName, emailAddress, companyName, countryName, stateProvince, cityName, address1, address2, zipCode, phoneNumber, faxNumber);
	
		Assert.assertEquals(addressPage.getToFullNameAddressTextbox(),fullName);
		Assert.assertEquals(addressPage.getToEmailAddressTextbox(),"Email: " + emailAddress);
		Assert.assertEquals(addressPage.getToPhoneAddressTextbox(),"Phone number: " + phoneNumber);
		Assert.assertEquals(addressPage.getToFaxAddressTextbox(),"Fax number: " + faxNumber);
		Assert.assertEquals(addressPage.getToCompanyAddressTextbox(),companyName);
		Assert.assertEquals(addressPage.getToAddress1Textbox(),address1);
		Assert.assertEquals(addressPage.getToAddress2Textbox(),address2);
		Assert.assertEquals(addressPage.getToCityZipCodeAddressTextbox(),citySateZip);
		Assert.assertEquals(addressPage.getToCountryAddressTextbox(),countryName);
	}

	@Test
	public void TC_03_Change_Password() {
		customerInfoPage = new CustomerInfoPageObject(driver);
		changePasswordPage = customerInfoPage.clickToChangePasswordButton();
		
		changePasswordPage.changePassword(password, newPassword);
		Assert.assertTrue(changePasswordPage.isChangePasswordSuccessMessageDisplayed());
		
		homePage= changePasswordPage.clickToCloseMessageButton();
		homePage.clickToLogoutLink();
		
		loginPage= homePage.clickToLoginLink();
		loginPage.loginToSystem(emailAddress, password);
		Assert.assertTrue(loginPage.isPasswordInvalidMessageDisplay());
		
		homePage = loginPage.loginToSystem(emailAddress, newPassword);
		Assert.assertTrue(homePage.isLogoutLinkDisplay());
	}

	@Test
	public void TC_04_My_Product_View() {
		String titleReview = "Automation";
		String textReview = "Very good";
		
		homePage = new HomePageObject(driver);
		homePage.hoverComputerLinkMenu();
		homePage.clickToDesktopSubMenu();
		homePage.clickToItemLink();
		reviewPage= homePage.clickToAddReviewLink();
		reviewPage.addReview(titleReview, textReview);
		Assert.assertEquals(reviewPage.getAddReviewSuccessMessage(),"Product review is successfully added.");
		
		homePage = new HomePageObject(driver);
		customerInfoPage= homePage.clickToMyAccountLink();
		reviewPage = customerInfoPage.clickToMyProductReviewLink();
		
		Assert.assertEquals(reviewPage.getTitleReviewText(), titleReview);
		Assert.assertEquals(reviewPage.getTextReviewText(), textReview);
		Assert.assertEquals(reviewPage.getInfoReviewText(), "Build your own computer");	
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
	CustomerInfoPageObject customerInfoPage;
	AddressPageObject addressPage;
	ChangePasswordPageObject changePasswordPage;
	ProductReviewPageObject reviewPage;
}
