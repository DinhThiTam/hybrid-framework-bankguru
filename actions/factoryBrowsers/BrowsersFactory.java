package factoryBrowsers;

import org.openqa.selenium.WebDriver;

public interface BrowsersFactory {
	
	public abstract WebDriver getBrowsersDriver();
}
