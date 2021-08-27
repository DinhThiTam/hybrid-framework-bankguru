package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.ChangePasswordPageUI;
import pageUIs.user.nopCommerce.CustomerInfoPageUI;
import pageUIs.user.nopCommerce.ProductReviewPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class PageGeneratorManager extends BasePage {
	
//	private static HomePageObject homePage;
//	private static RegisterPageObject registerPage;
//	private static LoginPageObject loginPage;
//	private static CustomerInfoPageObject customInfoPage;
//	private static AddressPageObject addressPage;
//	private static SearchPageObject searchPage;
//	private static ChangePasswordPageObject changePassPage;
//	private static ProductReviewPageObject productReviewPage;
//	private static NoteBooksPageObject noteBookPage;
//	private static OrderPageObject orderPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
//		if(homePage==null) {
//			homePage = new HomePageObject(driver);
//		}
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
//		if(registerPage==null) {
//			registerPage = new RegisterPageObject(driver);
//		}
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
//		if(loginPage==null) {
//			loginPage = new LoginPageObject(driver);
//		}
		return new LoginPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomInfoPage(WebDriver driver) {
//		if(customInfoPage==null) {
//			customInfoPage = new CustomerInfoPageObject(driver);
//		}
		return new CustomerInfoPageObject(driver);
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
//		if(addressPage==null) {
//			addressPage = new AddressPageObject(driver);
//		}
		return new AddressPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
//		if(searchPage==null) {
//			searchPage = new SearchPageObject(driver);
//		}
		return new SearchPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
//		if(productReviewPage==null) {
//			productReviewPage = new ProductReviewPageObject(driver);
//		}
		return new ProductReviewPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
//		if(changePassPage==null) {
//			changePassPage = new ChangePasswordPageObject(driver);
//		}
		return new ChangePasswordPageObject(driver);
	}
	
	public static NoteBooksPageObject getNoteBookPage(WebDriver driver) {
//		if(noteBookPage==null) {
//			noteBookPage = new NoteBooksPageObject(driver);
//		}
		return new NoteBooksPageObject(driver);
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
//		if(orderPage==null) {
//			orderPage = new OrderPageObject(driver);
//		}
		return new OrderPageObject(driver);
	}

	
	

	
}
