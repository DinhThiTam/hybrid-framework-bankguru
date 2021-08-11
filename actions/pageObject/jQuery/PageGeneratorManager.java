package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	
	private static HomePageObject homePage;
	
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage==null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}
	
}
