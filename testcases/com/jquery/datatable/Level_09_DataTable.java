package com.jquery.datatable;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	@Test
	public void Table_01_Paging() {
		homePage.openPageByNumber("15");
		homePage.sleepInsecond(3 );
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
	}
	
	@Test
	public void Table_02_Actions() {
		homePage.inputToHeaderTextboxByName("Females","34300");
		homePage.sleepInsecond(3);
		homePage.refreshPage(driver);
		homePage.inputToHeaderTextboxByName("Country", "Denmark");
		homePage.sleepInsecond(3);
		homePage.refreshPage(driver);
		homePage.inputToHeaderTextboxByName("Total", "71285");
		homePage.sleepInsecond(3);
		homePage.refreshPage(driver);
		
		homePage.clickToIconByCountryName("Angola", "remove");
		homePage.sleepInsecond(3);
		homePage.clickToIconByCountryName("Algeria", "edit");
	}
	
	//@Test
	public void Table_03_Verify_Row_Values() {
		homePage.inputToHeaderTextboxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplay("384187","Afghanistan","407124","791312"));
		homePage.sleepInsecond(3);	
	}
	
	//@Test
	public void Table_04_Input_Row_Textbox() {
		homePage.inputToTextboxByRowNumber("Contact Person","3","John");	
		homePage.sleepInsecond(3);
	}
	
	@Test
	public void Table_05_Click_Icon_At_Row() {
		homePage.clickToIconAtRowNumber("1","Move Up");	
		homePage.sleepInsecond(3);
		
		homePage.clickToIconAtRowNumber("2","Remove Current Row");	
		homePage.sleepInsecond(3);
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	
	
	HomePageObject homePage;
	
}
