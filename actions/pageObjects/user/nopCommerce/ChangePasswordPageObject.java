package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;
import pageUIs.user.nopCommerce.ChangePasswordPageUI;
import pageUIs.user.nopCommerce.LoginPageUI;
	
	public class ChangePasswordPageObject extends BasePage {
	private WebDriver driver;
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToOldPasswordTextbox(String value) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		senkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, value);
		
	}
	public void enterToNewPasswordTextbox(String value) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		senkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, value);
	}
	public void enterToConfirmPasswordTextbox(String value) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, value);
	}
	
	public void clickToChanePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}
	
	public boolean isChangePasswordSuccessMessageDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}
	
	public void changePassword(String password, String newPassword) {
		
		enterToOldPasswordTextbox(password);
		enterToNewPasswordTextbox(newPassword);
		enterToConfirmPasswordTextbox(newPassword);
		clickToChanePasswordButton();		
	}
	
	public HomePageObject clickToCloseMessageButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CLOSE_MESSAGE_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_MESSAGE_BUTTON);
		return new HomePageObject(driver);
	}
	
	
}
