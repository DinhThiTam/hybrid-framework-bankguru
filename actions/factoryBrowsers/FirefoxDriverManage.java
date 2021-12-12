package factoryBrowsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManage implements BrowsersFactory{

	@Override
	public WebDriver getBrowsersDriver() {
		WebDriverManager.firefoxdriver().setup();
		//add extensions
		FirefoxProfile profile = new FirefoxProfile();
		File extensionsFile = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "to_google_translate-4.2.0-fx.xpi");
		profile.addExtension(extensionsFile);	
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		//warning log console
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + File.separator + "monitorLogs" + File.separator + "Firefox.log");
		
		return new FirefoxDriver(options);
	}

}
