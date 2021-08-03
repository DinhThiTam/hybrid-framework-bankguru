package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;
import pageUIs.nopCommerce.RegisterPageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
	private WebDriver driver;
	
	public SearchPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchKeywordTextbox(String value) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		senkeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
		
	}
	
	}
	
