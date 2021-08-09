package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInfoPageUI;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.OrderPageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class OrderPageObject extends BasePage {
	private WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}


	
}
