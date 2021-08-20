package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;
import pageUIs.user.nopCommerce.AddressPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class ProductDetailPO extends BasePage {
	private WebDriver driver;
	
	public ProductDetailPO (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		//1 - get tag i attibute
		waitForElementVisible(driver,ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		//2 - if not contains (fa-plus)
		if (toogleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
	}


	public void enterToAltTextbox(String productImageAlt) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_NEW);
		senkeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_NEW, productImageAlt);	
	}

	public void enterToTitleTextbox(String productImageTitle) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW);
		senkeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, productImageTitle);
	}

	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);		
	}

//	public void enterToDisplayOrderTextbox(String productDisplay) {
//		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_PICTURE);
//		senkeyToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_PICTURE, productDisplay);	
//	}

	public boolean isPictureSuccessByFileName(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
	}

	public boolean isPictureImageDisplayed(String imageName, String displayOrder, String imageAlt, String imageTitle) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_ALT_TITLE_ORDER, imageName,displayOrder,imageAlt,imageTitle);
		return isElementDisplayed(driver, ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_ALT_TITLE_ORDER, imageName,displayOrder,imageAlt,imageTitle);
	}


	public void clickToDeleteButtonAtPictureName(String productTitle) {
		waitForElementClickable(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		sleepInsecond(2);
		acceptAlert(driver);
		
	}

	public ProductSearchPO clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDisplayOrderTextbox(String productDisplay) {
		waitForElementClickable(driver, ProductDetailPageUI.DISPLAY_ORDER_PICTURE);
		clickToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_PICTURE, productDisplay);
		
	}


	}
