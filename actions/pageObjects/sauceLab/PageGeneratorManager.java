package pageObjects.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	WebDriver driver;

	private PageGeneratorManager() {

	}

	public static LoginPO getLoginPage(WebDriver driver) {

		return new LoginPO(driver);
	}

	public static InventoryPO getInventoryPage(WebDriver driver) {

		return new InventoryPO(driver);
	}

}
