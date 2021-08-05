package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ChangePasswordPageUI;
import pageUIs.nopCommerce.CustomerInfoPageUI;
import pageUIs.nopCommerce.RegisterPageUI;

public class CustomerInfoPageObject extends BasePage {
	
	private WebDriver driver;

	public CustomerInfoPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, CustomerInfoPageUI.CHANGE_PASSWORD_LINK);
	}

	public void clickToAddressLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.ADDRESSES_LINK);
		clickToElementByJS(driver, CustomerInfoPageUI.ADDRESSES_LINK);
	}

	public void clickToCustomerInfoLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.CUSTOM_INFO_LINK);
		clickToElement(driver, CustomerInfoPageUI.CUSTOM_INFO_LINK);
	}

	public void clickToMyProductReviewLink() {
		waitForElementVisible(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
	}

	
}
