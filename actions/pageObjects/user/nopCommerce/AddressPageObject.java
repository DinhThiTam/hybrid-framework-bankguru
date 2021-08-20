package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.AddressPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;
	
	public AddressPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewLink() {
		waitForElementClickable(driver, AddressPageUI.ADD_NEW_LINK);
		clickToElement(driver, AddressPageUI.ADD_NEW_LINK);	
	}
	
	public void enterToFirsNameAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.FIRST_NAME_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.FIRST_NAME_ADDRESS_TEXTBOX, value);
	}
	
	public void enterToCompanyAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.COMPANY_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.COMPANY_ADDRESS_TEXTBOX, value);
	}
	public void enterToEmailAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.EMAIL_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.EMAIL_ADDRESS_TEXTBOX, value);
	}
	public void enterToLastNameAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.LAST_NAME_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.LAST_NAME_ADDRESS_TEXTBOX, value);
	}
	public void enterToCityAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.CITY_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.CITY_ADDRESS_TEXTBOX, value);
	}
	public void selectToCountryAddressTextbox(String itemText) {
		selectDropdownByText(driver, AddressPageUI.COUNTRY_ADDRESS_TEXTBOX, itemText);
	}
	public void enterToFaxAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.FAX_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.FAX_ADDRESS_TEXTBOX, value);
	}
	public void enterToZipCodeAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.ZIPCODE_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.ZIPCODE_ADDRESS_TEXTBOX, value);
	}
	public void enterToAddress1Textbox(String value) {
		waitForElementVisible(driver, AddressPageUI.ADDRESS1_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.ADDRESS1_ADDRESS_TEXTBOX, value);
	}
	public void clickToSaveAddressButton() {
		waitForElementClickable(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);	
	}
	public void selectToStateAddressTextbox(String itemText) {
		selectDropdownByText(driver, AddressPageUI.STATE_ADDRESS_TEXTBOX, itemText);
	}
	public void enterToPhoneAddressTextbox(String value) {
		waitForElementVisible(driver, AddressPageUI.PHONE_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.PHONE_ADDRESS_TEXTBOX, value);
	}
	public void enterToAddress2Textbox(String value) {
		waitForElementVisible(driver, AddressPageUI.ADDRESS2_ADDRESS_TEXTBOX);
		senkeyToElement(driver, AddressPageUI.ADDRESS2_ADDRESS_TEXTBOX, value);
	}
	
	public void addNewAddress(String firstName, String lastName, String emailAddress, String companyName, String countryName, String stateProvince, String cityName, String address1, String address2, String zipCode, String phoneNumber, String faxNumber) {
		enterToFirsNameAddressTextbox(firstName);
		enterToLastNameAddressTextbox(lastName);
		enterToEmailAddressTextbox(emailAddress);
		enterToCompanyAddressTextbox(companyName);
		selectToCountryAddressTextbox(countryName);
		selectToStateAddressTextbox(stateProvince);
		enterToCityAddressTextbox(cityName);
		enterToAddress1Textbox(address1);
		enterToAddress2Textbox(address2);
		enterToZipCodeAddressTextbox(zipCode);
		enterToPhoneAddressTextbox(phoneNumber);
		enterToFaxAddressTextbox(faxNumber);
		clickToSaveAddressButton();
	}
	public String getToCountryAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.COUNTRY_TEXT);
		return getElementText(driver, AddressPageUI.COUNTRY_TEXT);
	}
	
	public String getToCompanyAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.COMPANY_TEXT);
		return getElementText(driver, AddressPageUI.COMPANY_TEXT);
	}
	public String getToEmailAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.EMAIL_TEXT);
		return getElementText(driver, AddressPageUI.EMAIL_TEXT);
	}
	
	public String getToFaxAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.FAX_TEXT);
		return getElementText(driver, AddressPageUI.FAX_TEXT);
	}
	
	public String getToAddress2Textbox() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS2_TEXT);
		return getElementText(driver, AddressPageUI.ADDRESS2_TEXT);
	}
	public String getToAddress1Textbox() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS1_TEXT);
		return getElementText(driver, AddressPageUI.ADDRESS1_TEXT);
	}
	public String getToPhoneAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.PHONE_TEXT);
		return getElementText(driver, AddressPageUI.PHONE_TEXT);
	}
	
	public String getToCityZipCodeAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.CITY_STATE_TEXT);
		return getElementText(driver, AddressPageUI.CITY_STATE_TEXT);
	}

	public String getToFullNameAddressTextbox() {
		waitForElementVisible(driver, AddressPageUI.FULL_NAME_TEXT);
		return getElementText(driver, AddressPageUI.FULL_NAME_TEXT);
	}

}
