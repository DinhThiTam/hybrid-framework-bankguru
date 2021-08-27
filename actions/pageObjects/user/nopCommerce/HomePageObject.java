package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);	
		if(driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInsecond(3);
		}
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		if(driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInsecond(3);
		}
		return new LoginPageObject(driver);
	}
	
	public void clickToLogoutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElementByJS(driver, HomePageUI.LOGOUT_LINK);
	}
	
	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return new CustomerInfoPageObject(driver);
	}
	public boolean isLogoutLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}
	
	public void hoverComputerLinkMenu() {
		waitForElementVisible(driver, HomePageUI.COMPUTER_MENU_LINK);
		hoverToElement(driver, HomePageUI.COMPUTER_MENU_LINK);
		
	}
	public void clickToDesktopSubMenu() {
		waitForElementClickable(driver, HomePageUI.SUB_MENU_LINK);
		clickToElement(driver, HomePageUI.SUB_MENU_LINK);
	}
	public ProductReviewPageObject clickToAddReviewLink() {
		waitForElementClickable(driver, HomePageUI.ADD_REVIEW_LINK);
		clickToElement(driver, HomePageUI.ADD_REVIEW_LINK);
		return new ProductReviewPageObject(driver);
	}
	public void clickToItemLink() {
		waitForElementClickable(driver, HomePageUI.ITEM_LINK);
		clickToElement(driver, HomePageUI.ITEM_LINK);
		
	}
	public NoteBooksPageObject clickToSubNotebooksSubMenu() {
		// TODO Auto-generated method stub
		return null;
	}


}
