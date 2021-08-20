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
import pageObjects.user.nopCommerce.NoteBooksPageObject;
import pageObjects.user.nopCommerce.ProductReviewPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;


public class Practice_TC_05_Sort_Display_Paging extends BaseTest {
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
		firstName= "Automation" ; 
		lastName= "FC"; 
	}

	@Test
	public void TC_01_Sort_By_Name_A_Z() {
		homePage = new HomePageObject(driver);
		homePage.hoverComputerLinkMenu();
		noteBooks= homePage.clickToSubNotebooksSubMenu();
		noteBooks.selectSortByNameAToZDropDown("Name: A to Z");
		
		
		
	}

	@Test
	public void TC_02_Sort_By_Name_Z_A() {
	
	}
	
	@Test
	public void TC_03_Sort_By_Price_Low_To_Hight() {
		searchPage.enterSearchKeywordTextbox("Lenovo");
		searchPage.clickToSearchButton();
		
		Assert.assertTrue(searchPage.isTitleProduct1Link());
		Assert.assertTrue(searchPage.isTitleProduct2Link());
		Assert.assertEquals(searchPage.getSizeProductText(), 2);
	}
	@Test
	public void TC_04_Display_Three_Per_Page() {
		searchPage.enterSearchKeywordTextbox("Thinkpad X1 Carbon");
		searchPage.clickToSearchButton();
		
		Assert.assertTrue(searchPage.isTitleProduct2Link());
		Assert.assertEquals(searchPage.getSizeProductText(), 1);
	}
	
	@Test
	public void TC_05_Display_Three_Per_Page() {
		searchPage.enterSearchKeywordTextbox("Apple MacBook Pro");
		searchPage.checkToAdvancedSearchCheckbox();
		Assert.assertTrue(searchPage.isAdvancedSearchChecked());
		searchPage.selectItemCategoryDropdown("Computers");
		Assert.assertEquals(searchPage.getItemSelected(), "Computers");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isParentCategoriesDisplayedMessage());
	}
	
	@Test
	public void TC_06_Display_Six_Per_Page() {
		Assert.assertEquals(searchPage.getSearchKeywordTextbox(), "Apple MacBook Pro");
		Assert.assertTrue(searchPage.isAdvancedSearchChecked());
		Assert.assertEquals(searchPage.getItemSelected(), "Computers");
		searchPage.checkToAutomationSearchCheckbox();
		Assert.assertTrue(searchPage.isAutomationSearchChecked());
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getSizeProductText(), 1);
		Assert.assertTrue(searchPage.isTitleProduct3Link());
	}
	
	@Test
	public void TC_07_Display_Nine_Per_Page() {
		Assert.assertEquals(searchPage.getSearchKeywordTextbox(), "Apple MacBook Pro");
		Assert.assertTrue(searchPage.isAdvancedSearchChecked());
		Assert.assertEquals(searchPage.getItemSelected(), "Computers");
		searchPage.checkToAutomationSearchCheckbox();
		Assert.assertTrue(searchPage.isAutomationSearchChecked());
		searchPage.selectItemManufacturerDropdown("HP");
		Assert.assertEquals(searchPage.getItemManufacturerSelected(), "HP");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isIncorrectManufactunerMessage());
	}
	
	@Test
	public void TC_08_Correct_Manufactuner() {
		Assert.assertEquals(searchPage.getSearchKeywordTextbox(), "Apple MacBook Pro");
		Assert.assertTrue(searchPage.isAdvancedSearchChecked());
		Assert.assertEquals(searchPage.getItemSelected(), "Computers");
		Assert.assertTrue(searchPage.isAutomationSearchChecked());
		searchPage.selectItemManufacturerDropdown("Apple");
		Assert.assertEquals(searchPage.getItemManufacturerSelected(), "Apple");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getSizeProductText(), 1);
		Assert.assertTrue(searchPage.isTitleProduct3Link());
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
	CustomerInfoPageObject myAccountPage;
	AddressPageObject addressPage;
	ChangePasswordPageObject changePasswordPage;
	ProductReviewPageObject reviewPage;
	SearchPageObject searchPage;
	NoteBooksPageObject noteBooks;
}
