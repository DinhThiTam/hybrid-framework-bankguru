package pageObjects.faceBook;


import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	
	private static RegisterPageObject registerPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage==null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	
	}
	
