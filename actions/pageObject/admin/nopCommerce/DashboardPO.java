package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.AddressPageUI;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class DashboardPO extends BasePage {
	private WebDriver driver;
	
	public DashboardPO (WebDriver driver) {
		this.driver = driver;
	}


}
