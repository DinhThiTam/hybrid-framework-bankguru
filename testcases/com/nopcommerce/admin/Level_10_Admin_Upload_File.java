package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObject.admin.nopCommerce.DashboardPO;
import pageObject.admin.nopCommerce.LoginPO;
import pageObject.admin.nopCommerce.PageGeneratorManager;
import pageObject.admin.nopCommerce.ProductDetailPO;
import pageObject.admin.nopCommerce.ProductSearchPO;



public class Level_10_Admin_Upload_File extends BaseTest{
	WebDriver driver;
	String productName = "Adobe Photoshop CS4";
	String productAdobeImg="Adobe.jpg";
	String productAdobeAlt="Adobe Alt";
	String productAdobeTitle="Adobe Title";
	String productAdobeDisplay="1";
	LoginPO loginPage;
	DashboardPO dashboardPage;
	ProductSearchPO productSearchPage;
	ProductDetailPO productDetailPage;
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		//loginPage.enterToEmailTextbox("admin@yourstore.com");
		//loginPage.enterToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		dashboardPage.openSubMenuPageByName(driver, "Catalog","Products");
		productSearchPage = PageGeneratorManager.getProductSearchPage(driver);
		
		
		productSearchPage.enterToProductNameTextBox(productName);
		productSearchPage.clickToSearchButton();
		productDetailPage= productSearchPage.clickToEditButtonByProductName(productName);
		
	}
	
	@Test
	public void Admin_01_Upload_File() {
		
		productDetailPage.clickToExpandPanelByName("Pictures");
		productDetailPage.uploadMultipleFilesAtCardName(driver, "pictures", productAdobeImg);
		Assert.assertTrue(productDetailPage.isPictureSuccessByFileName(""));
		productDetailPage.enterToAltTextbox(productAdobeAlt);
		productDetailPage.enterToTitleTextbox(productAdobeTitle);
		productDetailPage.clickToDisplayOrderTextbox(productAdobeDisplay);
		productDetailPage.clickToAddProductPictureButton();
		Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName, productAdobeDisplay, productAdobeAlt,productAdobeTitle));
		productSearchPage = productDetailPage.clickToSaveButton();
		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully"));
		
		productSearchPage.enterToProductNameTextBox("Adobe Photoshop CS4");
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName, productName));
		
		productDetailPage= productSearchPage.clickToEditButtonByProductName(productName);
		productDetailPage.clickToExpandPanelByName("Pictures");
		productDetailPage.clickToDeleteButtonAtPictureName(productAdobeTitle);//dịnh nghĩa luôn accepte alert
		Assert.assertTrue(productDetailPage.isMessageDisplayedInEmptyTable(driver, "productpictures"));
		
		productSearchPage = productDetailPage.clickToSaveButton();
		
		productSearchPage.enterToProductNameTextBox(productName);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated("default-image", productName));	
	}
	
	@Test
	public void Login_02_Login_To_System() {
	
	}
	
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	

}
