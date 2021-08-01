package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;
import pageUIs.nopCommerce.LoginPageUI;
	
	public class LoginPageObject extends BasePage {
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}
	
	public boolean isEmailEmptyMessageDisplay() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_EMAIL_EMPTY_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_EMAIL_EMPTY_MESSAGE);
	}
	
	public boolean isEmailInvalidMessageDisplay() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_EMAIL_INVALID_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_EMAIL_INVALID_MESSAGE);
	}
	
	public boolean isEmailNotRegisterMessageDisplay() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_EMAIL_NOT_REGISTER_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_EMAIL_NOT_REGISTER_MESSAGE);
	}
	
	public boolean isPasswordEmptyMessageDisplay() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_PASSWORD_EMPTY_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_PASSWORD_EMPTY_MESSAGE);
	}
	
	public boolean isPasswordInvalidMessageDisplay() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_PASSWORD_INVALID_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_PASSWORD_INVALID_MESSAGE);
	}
	
	public void loginToSystem(String emailAddress, String password ) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		clickToLoginButton();
	}
	
}
