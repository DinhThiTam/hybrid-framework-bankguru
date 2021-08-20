package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;
import pageUIs.user.nopCommerce.SearchPageUI;

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

	public boolean isSearchKeywordEmptyMessage() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_EMPTY_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.SEARCH_KEYWORD_EMPTY_MESSAGE);
	}

	public boolean isSearchKeywordNotExistMessage() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_NOT_EXIST_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.SEARCH_KEYWORD_NOT_EXIST_MESSAGE);
	}

	public boolean isTitleProduct1Link() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_TITLE_01_LINK);
		return isElementDisplayed(driver, SearchPageUI.PRODUCT_TITLE_01_LINK);
	}

	public boolean isTitleProduct2Link() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_TITLE_02_LINK);
		return isElementDisplayed(driver, SearchPageUI.PRODUCT_TITLE_02_LINK);
	}

	public int getSizeProductText() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_TITLE_SIZE);
		return getSizeElements(driver, SearchPageUI.PRODUCT_TITLE_SIZE );
	}


	public boolean isAdvancedSearchChecked() {
		return isElementSelected(driver, SearchPageUI.ADVANCED_CHECKBOX);
	}

	public void selectItemCategoryDropdown(String itemText) {
		selectDropdownByText(driver, SearchPageUI.CATEGORY_DROPDOWN, itemText);
	}

	public boolean isParentCategoriesDisplayedMessage() {
		waitForElementVisible(driver, SearchPageUI.PARENT_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.PARENT_MESSAGE);
	}


	public void checkToAdvancedSearchCheckbox() {
		waitForElementVisible(driver, SearchPageUI.ADVANCED_CHECKBOX);
		checkTheCheckboxOrRadio(driver, SearchPageUI.ADVANCED_CHECKBOX);
	}


	public boolean isTitleProduct3Link() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_TITLE_03_LINK);
		return isElementDisplayed(driver, SearchPageUI.PRODUCT_TITLE_03_LINK);
	}

	public String getItemSelected() {
		return getSelectedItemDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN);
	}

	public String getSearchKeywordTextbox() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		return getElementAttribute(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, "value");
	}

	public void checkToAutomationSearchCheckbox() {
		waitForElementVisible(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
		checkTheCheckboxOrRadio(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
	}

	public boolean isAutomationSearchChecked() {
		return isElementSelected(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
	}


	public String getItemManufacturerSelected() {
		return getSelectedItemDropdown(driver, SearchPageUI.MANUFACTUNER_DROPDOWN);
	}


	public boolean isIncorrectManufactunerMessage() {
		waitForElementVisible(driver, SearchPageUI.INCORRECT_MANUFACTUNER_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.INCORRECT_MANUFACTUNER_MESSAGE);
	}

	public void selectItemManufacturerDropdown(String itemText) {
		selectDropdownByText(driver, SearchPageUI.MANUFACTUNER_DROPDOWN, itemText);
	}


	}
	
