package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;
import pageUIs.user.nopCommerce.AddressPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class ProductSearchPO extends BasePage {
	private WebDriver driver;
	
	public ProductSearchPO (WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextBox(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		senkeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
		
	}

	public boolean isSuccessMessageDisplayed(String mesageName) {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, mesageName);
		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, mesageName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);	
	}

	public boolean isPictureImageUpdated(String productImageName, String productName) {
		productImageName = productImageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName,productImageName);
		return isElementDisplayed(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName,productImageName);
	}

	public ProductDetailPO clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);	
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isPictureImageUpdated(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
}
