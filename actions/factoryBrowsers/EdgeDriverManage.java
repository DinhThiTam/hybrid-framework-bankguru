package factoryBrowsers;

import java.io.File;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManage implements BrowsersFactory{

	@Override
	public WebDriver getBrowsersDriver() {
		if (!IS_OS_WINDOWS || !IS_OS_MAC){
			throw new BrowserNotSupportedException("Edge is not supported on " + System.getProperty("os.name"));
		}
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		
		return new EdgeDriver(options);
}
}
