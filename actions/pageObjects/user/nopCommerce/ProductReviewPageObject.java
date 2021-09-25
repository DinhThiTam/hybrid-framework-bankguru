package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.ChangePasswordPageUI;
import pageUIs.user.nopCommerce.CustomerInfoPageUI;
import pageUIs.user.nopCommerce.ProductReviewPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class ProductReviewPageObject extends BasePage {
	
	private WebDriver driver;

	public ProductReviewPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTitleReviewTextbox(String value) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		senkeyToElement(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX, value);	
	}

	public void enterToTextReviewTextbox(String value) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
		senkeyToElement(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX, value);
	}

	public void clickToSubmitReviewButton() {
		waitForElementVisible(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}
	
	public void addReview(String titleReview, String textReview) {
		enterToTitleReviewTextbox(titleReview);
		enterToTextReviewTextbox(textReview);
		clickToSubmitReviewButton();	
	}

	public String getAddReviewSuccessMessage() {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, ProductReviewPageUI.REVIEW_SUCCESS_MESSAGE);
	}

	public String getTitleReviewText() {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE_TEXT);
		return getElementText(driver, ProductReviewPageUI.REVIEW_TITLE_TEXT);
	}

	public String getTextReviewText() {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT_TEXT);
		return getElementText(driver, ProductReviewPageUI.REVIEW_TEXT_TEXT);
	}

	public String getInfoReviewText() {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_INFO_TEXT);
		return getElementText(driver, ProductReviewPageUI.REVIEW_INFO_TEXT);
	}

	

	
}
