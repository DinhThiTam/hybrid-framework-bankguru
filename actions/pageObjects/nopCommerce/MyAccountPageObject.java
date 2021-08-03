package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ChangePasswordPageUI;
import pageUIs.nopCommerce.MyAccountPageUI;
import pageUIs.nopCommerce.RegisterPageUI;

public class MyAccountPageObject extends BasePage {
	
	private WebDriver driver;

	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
	}

	public void clickToAddressLink() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_LINK);
		clickToElementByJS(driver, MyAccountPageUI.ADDRESSES_LINK);
	}

	public void clickToCustomerInfoLink() {
		waitForElementClickable(driver, MyAccountPageUI.CUSTOM_INFO_LINK);
		clickToElement(driver, MyAccountPageUI.CUSTOM_INFO_LINK);
	}

	
}
