package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageURL (WebDriver driver) {
		return driver.getCurrentUrl();
		
	}
	
	public String getPageSouce(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backPage (WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardPage (WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage (WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void waitAlertPresence (WebDriver driver ) {
		//alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void acceptAlert (WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();	
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void senkeyToAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	
	private Alert alert;
	WebDriver explicitWait;
}
	
