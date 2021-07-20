package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public Alert waitAlertPresence (WebDriver driver ) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());	
	}
	
	public void acceptAlert (WebDriver driver) {
		alert = waitAlertPresence(driver);
		alert.accept();	
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		alert.dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		return alert.getText();
	}
	
	public void senkeyToAlert(WebDriver driver, String value) {
		alert = waitAlertPresence(driver);
		alert.sendKeys(value);
	}
	
	public void switchWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
			
		}
	}
	
	public void switchToWindowByTitle (WebDriver driver, String pageTitle) {
		//Get hết ra các id đang có
		Set<String> allWindowIDs = driver.getWindowHandles();
		//Duyệt qua các giá trị trong all windows, switch qua window rồi getTitle của window ra, nếu title thực tế bằng với title của window vừa switch thì done, thoát khỏi vòng lặp
		for (String id : allWindowIDs) {	
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle().trim();
			if (actualTitle.equals(pageTitle)) {
			break;
			}
		}
	}
	public void closeAlltabWithoutParent (WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			
		}
	}
	public void sleepInsecond(long timeoutInsecond){
		try {
			Thread.sleep(timeoutInsecond *1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeout = 20;
}
	
