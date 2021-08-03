package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);	
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
	
	public void clickToLogoutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElementByJS(driver, HomePageUI.LOGOUT_LINK);
	}
	public boolean isToppicTitleDisplay() {
		waitForElementInvisible(driver, HomePageUI.TOPIC_TITLE);
		return isElementDisplayed(driver, HomePageUI.TOPIC_TITLE);
	}
	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	public boolean isLogoutLinkDisplay() {
		waitForElementInvisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}
	public void scrollToTopicTitle() {
		scrollToElement(driver, HomePageUI.TOPIC_TITLE);
		
	}
	public void hoverComputerLinkMenu() {
		waitForElementVisible(driver, HomePageUI.COMPUTER_MENU_LINK);
		hoverToElement(driver, HomePageUI.COMPUTER_MENU_LINK);
		
	}
	public void clickToDesktopSubMenu() {
		waitForElementClickable(driver, HomePageUI.SUB_MENU_LINK);
		clickToElement(driver, HomePageUI.SUB_MENU_LINK);
	}
	public void clickToAddReviewLink() {
		waitForElementClickable(driver, HomePageUI.ADD_REVIEW_LINK);
		clickToElement(driver, HomePageUI.ADD_REVIEW_LINK);
	}
	public void clickToItemLink() {
		waitForElementClickable(driver, HomePageUI.ITEM_LINK);
		clickToElement(driver, HomePageUI.ITEM_LINK);
		
	}

}
