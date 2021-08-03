package com.nopcommerce.login;

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
import pageObjects.nopCommerce.AddressPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageUIs.nopCommerce.RegisterPageUI;

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
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.registerToSystem(emailAddress, password, password, "dinh", "tam");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.refreshPage(driver);
		loginPage.loginToSystem(emailAddress, password);
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.clickToCustomerInfoLink();
		registerPage = new RegisterPageObject(driver);

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
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.clickToAddressLink();
		addressPage = new AddressPageObject(driver);
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
		myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.clickToChangePasswordButton();
		changePasswordPage = new ChangePasswordPageObject(driver);
		
		changePasswordPage.enterToOldPasswordTextbox(password);
		changePasswordPage.enterToNewPasswordTextbox(newPassword);
		changePasswordPage.enterToConfirmPasswordTextbox(newPassword);
		changePasswordPage.clickToChanePasswordButton();
		Assert.assertTrue(changePasswordPage.isChangePasswordSuccessMessageDisplayed());
		changePasswordPage.clickToCloseMessageButton();
		
		homePage = new HomePageObject(driver);
		homePage.clickToLogoutLink();
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.loginToSystem(emailAddress, password);
		Assert.assertTrue(loginPage.isPasswordInvalidMessageDisplay());
		loginPage.refreshPage(driver);
		loginPage.loginToSystem(emailAddress, newPassword);
		homePage = new HomePageObject(driver);
		homePage.clickToLogoutLink();
		
		
	}

	@Test
	public void TC_04_My_Product_View() {

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
}
