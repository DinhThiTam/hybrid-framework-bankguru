package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.HRMBasePageUI;
import pageUIs.hrm.MyInfoPageUI;


public class MyInfoPO extends BasePage {
	WebDriver driver;
	
	public MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePhotoImage() {
		waitForElementClickable(driver, MyInfoPageUI.AVATAR_IMAGE);
		clickToElement(driver, MyInfoPageUI.AVATAR_IMAGE);
		
	}

	
	public boolean isNewAvatarImageDisplayed() {
		waitForElementClickable(driver, MyInfoPageUI.AVATAR_IMAGE);
		int imageWidth = Integer.parseInt(getElementAttribute(driver, MyInfoPageUI.AVATAR_IMAGE, "width"));
		int imageHeight = Integer.parseInt(getElementAttribute(driver, MyInfoPageUI.AVATAR_IMAGE, "height"));
		return (imageWidth!=200) || (imageHeight!=200);
	}
	
	public void openTabMenuByName(String tabName) {
		waitForElementClickable(driver, MyInfoPageUI.TAB_MENU_BY_NAME, tabName);
		clickToElement(driver, MyInfoPageUI.TAB_MENU_BY_NAME, tabName);
	}
	
	
	
	

	
	


}
