package pageObjects.faceBook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.faceBook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;


	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isEmailTexboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}


	public void enterToEmailTexbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);	
	}


	public boolean isConfirmEmailTexboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}


	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}


	public boolean isLoginButtonUnDisplayed() {
		return isElementUnDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}


}
