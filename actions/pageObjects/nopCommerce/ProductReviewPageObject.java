package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ChangePasswordPageUI;
import pageUIs.nopCommerce.MyAccountPageUI;
import pageUIs.nopCommerce.ProductReviewPageUI;
import pageUIs.nopCommerce.RegisterPageUI;

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
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextReviewText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInfoReviewText() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
