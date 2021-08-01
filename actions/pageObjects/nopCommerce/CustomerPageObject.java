package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;

public class CustomerPageObject extends BasePage {
	private WebDriver driver;
	
	public CustomerPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToGenderRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}
	
	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);	
	}
	
	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);	
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);	
	}
	
	public boolean isEmailInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_INVALID_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_INVALID_MESSAGE);
	}
	
	public boolean isEmailExistMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXIST_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EXIST_MESSAGE);
	}

	public boolean isEmailEmptyMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EMPTY_MESSAGE);
	}
	
	public boolean isPasswordInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_INVALID_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_INVALID_MESSAGE);
	}
	
	public boolean isConfirmPasswordInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_INVALID_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_INVALID_MESSAGE);
	}
	
	public boolean isFirstnameEmptyInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.FIRSTNAME_EMPTY_MESSAGE);
	}
	
	public boolean isLastnameEmptyInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.LASTNAME_EMPTY_MESSAGE);
	}
	
	public boolean isPasswordEmptyInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_EMPTY_MESSAGE);
	}
	
	public boolean isConfirmPasswordEmptyInvalidMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_MESSAGE);
	}
	
	public void registerToSystem(String emailAddress, String password, String confirmPassword, String firstName, String lastName ) {
		clickToGenderRadioButton();
		enterToFirstNameTextbox(firstName);
		enterToLastNameTextbox(lastName);
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		enterToConfirmPasswordTextbox(confirmPassword);
		clickToRegisterButton();
	}
}
