package factoryEnvironment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;
import factoryBrowsers.BrowsersList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;
	
	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	
	public WebDriver createDriver () {
		BrowsersList browser = BrowsersList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		
		if (browser==BrowsersList.FIREFOX) {
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
			
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capability);
		} else if (browser==BrowsersList.CHROME) {
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
			
		} else if (browser==BrowsersList.IE) {
			WebDriverManager.iedriver().arch32().driverVersion("3.141.59").setup();
			driver = new InternetExplorerDriver();
			
		} else if (browser==BrowsersList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else if (browser==BrowsersList.SAFARI) {
			driver = new SafariDriver();
			
		} else if (browser==BrowsersList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			
		} else if (browser==BrowsersList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else {
			throw new RuntimeException("Please enter browser correct");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress,portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
