package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.HRMBasePageUI;
import pageUIs.hrm.PersonalDetailsPageUI;


public class PersonalDetailsPO extends BasePage {
	WebDriver driver;
	
	public PersonalDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePhotoImage() {
		waitForElementClickable(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		clickToElement(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		
	}

	public boolean isUploadMessageSuccessDisplayed() {
		waitForElementVisible(driver, PersonalDetailsPageUI.UPLOAD_AVATAR_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, PersonalDetailsPageUI.UPLOAD_AVATAR_SUCCESS_MESSAGE);
	}
	
	public boolean isNewAvaterImageDisplayed() {
		waitForElementClickable(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		int imageWidth = Integer.parseInt(getElementAttribute(driver, PersonalDetailsPageUI.AVATAR_IMAGE, "width"));
		int imageHeight = Integer.parseInt(getElementAttribute(driver, PersonalDetailsPageUI.AVATAR_IMAGE, "height"));
		return (imageWidth!=200) || (imageHeight!=200);
	}


}
