package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.ChangePasswordPageUI;
import pageUIs.user.nopCommerce.CustomerInfoPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class CustomerInfoPageObject extends BasePage {
	
	private WebDriver driver;

	public CustomerInfoPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public ChangePasswordPageObject clickToChangePasswordButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, CustomerInfoPageUI.CHANGE_PASSWORD_LINK);
		return new ChangePasswordPageObject(driver);
	}

	public AddressPageObject clickToAddressLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.ADDRESSES_LINK);
		clickToElementByJS(driver, CustomerInfoPageUI.ADDRESSES_LINK);
		return new AddressPageObject(driver);
	}

	public RegisterPageObject clickToCustomerInfoLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.CUSTOM_INFO_LINK);
		clickToElement(driver, CustomerInfoPageUI.CUSTOM_INFO_LINK);
		return new RegisterPageObject(driver);
	}

	public ProductReviewPageObject clickToMyProductReviewLink() {
		waitForElementVisible(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		return new ProductReviewPageObject(driver);
	}





	
}
