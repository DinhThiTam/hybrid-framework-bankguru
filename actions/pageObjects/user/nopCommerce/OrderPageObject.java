package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.CustomerInfoPageUI;
import pageUIs.user.nopCommerce.HomePageUI;
import pageUIs.user.nopCommerce.OrderPageUI;
import pageUIs.user.nopCommerce.SearchPageUI;

public class OrderPageObject extends BasePage {
	private WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}


	
}
