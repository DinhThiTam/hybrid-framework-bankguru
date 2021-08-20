package basic;

import java.io.File;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import pageUIs.admin.nopCommerce.AdminPageUI;

public class Dynamic_Locator {

	public static void main(String[] args) {
		String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
		String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	String CUSTOMER_INFO_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
	String DYNAMIC_PAGE_FOOTER= "//div[@class='footer']//a[text()='%s']";
		clickToElement(ORDER_PAGE_FOOTER);
		clickToElement(ORDER_PAGE_FOOTER, "My account");
		String PROJECT_PATH = System.getProperty("user.dir");
		 String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
		 System.out.println(UPLOAD_FOLDER_PATH);
	}	
	
	public static void clickToElement(String locator) {
		System.out.println(locator);
	}
	
	public static void clickToElement(String locator, String pageName) {
		System.out.println(String.format(locator, pageName));
	}
	
	public static void clickToElement(String locator, String pageName, String text) {
		System.out.println(String.format(locator, pageName, text));
	}
	public static void clickToElement(String locator, String... params) {
		System.out.println(String.format(locator,(Object[])params));
	}
	
	public void uploadMultipleFilesAtCardName(WebDriver driver, String cardName, String... fileNames) {
		String filePath = GlobalConstants.PROJECT_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		
	}
	
}
