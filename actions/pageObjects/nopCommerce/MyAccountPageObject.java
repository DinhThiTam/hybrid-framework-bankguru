package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyAccountPageUI;
import pageUIs.nopCommerce.RegisterPageUI;

public class MyAccountPageObject extends BasePage {
	
	private WebDriver driver;

	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerInfoLink() {
		waitForElementClickable(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
	}


	
	
}
