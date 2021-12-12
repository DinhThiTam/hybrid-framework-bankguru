package factoryBrowsers;

import java.io.File;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDriverManage implements BrowsersFactory{

	@Override
	public WebDriver getBrowsersDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.addArguments("window-size=1920x1080");
		return new ChromeDriver(options);
}
}
