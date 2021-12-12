package factoryEnvironment;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;
import factoryBrowsers.BrowserNotSupportedException;
import factoryBrowsers.BrowsersList;
import factoryBrowsers.ChromeDriverManage;
import factoryBrowsers.EdgeDriverManage;
import factoryBrowsers.FirefoxDriverManage;
import factoryBrowsers.HeadlessChromeDriverManage;
import factoryBrowsers.HeadlessFirefoxDriverManage;
import factoryBrowsers.IEDriverManage;
import factoryBrowsers.SafariDriverManage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver () {
		BrowsersList browser = BrowsersList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case CHROME:
			driver = new ChromeDriverManage().getBrowsersDriver();
			break;
		
		case FIREFOX:
			driver = new FirefoxDriverManage().getBrowsersDriver();
			break;
			
		case IE:
			driver = new IEDriverManage().getBrowsersDriver();
			break;
			
		case EDGE:
			driver = new EdgeDriverManage().getBrowsersDriver();
			break;
			
		case SAFARI:
			driver = new SafariDriverManage().getBrowsersDriver();
			break;
			
		case H_CHROME:
			driver = new HeadlessChromeDriverManage().getBrowsersDriver();
			break;
			
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManage().getBrowsersDriver();
			break;
		default:
			throw new BrowserNotSupportedException(browserName);
		}

		return driver;
	}
}
