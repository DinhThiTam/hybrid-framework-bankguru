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
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver () {
		Browsers browser = Browsers.valueOf(browserName.toUpperCase());
		if (browser==Browsers.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			//add extensions
//			FirefoxProfile profile = new FirefoxProfile();
//			File extensionsFile = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "to_google_translate-4.2.0-fx.xpi");
//			profile.addExtension(extensionsFile);
//			
//			FirefoxOptions options = new FirefoxOptions();
//			options.setProfile(profile);
//			driver = new FirefoxDriver(options);
			//warning log console
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + File.separator + "monitorLogs" + File.separator + "Firefox.log");
			
			driver = new FirefoxDriver();
		} else if (browser==Browsers.CHROME) {
			//Latest official
			WebDriverManager.chromedriver().setup();
			
			//Older version
			//WebDriverManager.chromedriver().driverVersion("90.0.4430.24").setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "extension_1_6_0_0.crx"));
			
//			options.setExperimentalOption("useAutomationExtension", false);
//			options.addArguments("--disable-notifications");
//			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			
		} else if (browser==Browsers.IE) {
			WebDriverManager.iedriver().arch32().driverVersion("3.141.59").setup();
			driver = new InternetExplorerDriver();
			
		} else if (browser==Browsers.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else if (browser==Browsers.SAFARI) {
			driver = new SafariDriver();
			
		} else if (browser==Browsers.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			
		} else if (browser==Browsers.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else {
			throw new RuntimeException("Please enter browser correct");
		}
		
		return driver;
	}
}
