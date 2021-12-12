package factoryBrowsers;

import java.io.File;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SafariDriverManage implements BrowsersFactory{

	@Override
	public WebDriver getBrowsersDriver() {
		if (!IS_OS_MAC){
			throw new BrowserNotSupportedException("Safari is not supported on " + System.getProperty("os.name"));
		}
		SafariOptions options = new SafariOptions();
		options.setCapability("safari.cleanSession", true);
		
		return new SafariDriver(options);
}
}
