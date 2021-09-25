package com.saucelab.sort;


import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.sauceLab.InventoryPO;
import pageObjects.sauceLab.LoginPO;
import pageObjects.sauceLab.PageGeneratorManager;

public class Level_18_Sort extends BaseTest{
	String projectLocation = System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Step 01: Open browser '"+ browserName + "' and navigate '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Open inventor page");
		loginPage.enterToUsernameTextbox̣("standard_user");
		loginPage.enterToPasswordTextbox̣("secret_sauce");
		inventoryPage = loginPage.clickToLoginButton();	
	}
	@Test
	public void Sort_01_Name_Ascending() {
		log.info("Sort_01 - Step 02: Select item in sort dropdown");
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(inventoryPage.isProductNameSortAscending());
	}
	
	@Test
	public void Sort_02_Name_Descending() {
		log.info("Sort_01 - Step 02: Select item in sort dropdown");
		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
	
		verifyTrue(inventoryPage.isProductNameSortDescending());
	}
	
	@Test
	public void Sort_03_Price_Ascending() {
		log.info("Sort_01 - Step 02: Select item in sort dropdown");
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		verifyTrue(inventoryPage.isPriceSortAscending());
	}
	
	@Test
	public void Sort_04_Price_Descending() {
		log.info("Sort_01 - Step 02: Select item in sort dropdown");
		inventoryPage.selectItemInSortDropdown("Price (high to low)");
		verifyTrue(inventoryPage.isPriceSortDescending());
	}

	
	@Parameters({"browser"})
	@AfterClass(alwaysRun=true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition - Close Browser - " + browserName + "");
		cleanBrowserAndDriver();
	}
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;
}



