package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.ChangePasswordPageUI;
import pageUIs.user.nopCommerce.CustomerInfoPageUI;
import pageUIs.user.nopCommerce.ProductReviewPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class PageGeneratorManager extends BasePage {
	
	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	private static CustomerInfoPageObject customInfoPage;
	private static AddressPageObject addressPage;
	private static SearchPageObject searchPage;
	private static ChangePasswordPageObject changePassPage;
	private static ProductReviewPageObject productReviewPage;
	private static NoteBooksPageObject noteBookPage;
	private static OrderPageObject orderPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage==null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage==null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage==null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static CustomerInfoPageObject getCustomInfoPage(WebDriver driver) {
		if(customInfoPage==null) {
			customInfoPage = new CustomerInfoPageObject(driver);
		}
		return customInfoPage;
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		if(addressPage==null) {
			addressPage = new AddressPageObject(driver);
		}
		return addressPage;
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage==null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		if(productReviewPage==null) {
			productReviewPage = new ProductReviewPageObject(driver);
		}
		return productReviewPage;
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		if(changePassPage==null) {
			changePassPage = new ChangePasswordPageObject(driver);
		}
		return changePassPage;
	}
	
	public static NoteBooksPageObject getNoteBookPage(WebDriver driver) {
		if(noteBookPage==null) {
			noteBookPage = new NoteBooksPageObject(driver);
		}
		return noteBookPage;
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		if(orderPage==null) {
			orderPage = new OrderPageObject(driver);
		}
		return orderPage;
	}

	
	

	
}
