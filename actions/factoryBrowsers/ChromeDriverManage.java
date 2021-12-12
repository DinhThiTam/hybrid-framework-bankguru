package factoryBrowsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManage implements BrowsersFactory{

	@Override
	public WebDriver getBrowsersDriver() {
		//Latest official
		WebDriverManager.chromedriver().setup();
		
		//Older version
		//WebDriverManager.chromedriver().driverVersion("90.0.4430.24").setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "extension_1_6_0_0.crx"));
		
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		return new ChromeDriver(options);
	}

}
