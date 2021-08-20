package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.liveGuru.MyDashboardPageUI;
import pageUIs.user.nopCommerce.LoginPageUI;
	
	public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToEmailTextbox(String emailAddress) {
		
	}

	public void clickToLoginButton() {
		
	}

	public void enterToPasswordTextbox(String password) {
			
	}
	
	public boolean isEmailEmptyMessageDisplay() {
		return false;
	}
	
	public boolean isEmailInvalidMessageDisplay() {
		return false;
	}
	
	public boolean isEmailNotRegisterMessageDisplay() {
		return false;
	}
	
	public boolean isPasswordEmptyMessageDisplay() {
		return false;
	}
	
	public boolean isPasswordInvalidMessageDisplay() {
		return false;
	}
	
	
	
}
