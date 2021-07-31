package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE, H_CHROME, H_FIREFOX; 
	}
	
	private enum OS {
		WINDOWS, MAC_OSX, LINUX;
	}
	
	private enum PLATFORM {
		ANDROID, IOS, WINDOW_PHONE;
	}
	
//	public WebDriver getBrowserDriver(String browserName) {
//		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
//		if (browser==BROWSER.FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//			//Check driver version hiện tại là bao nhiêu
//			//Tải về
//			//Init browser 
//			//System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
//			//System.setProperty("webdriver.gecko.driver", projectLocation + getDirectorySlash("browserDrivers")+ "geckodriver.exe");
//			driver = new FirefoxDriver();
//			System.out.println("Driver init at BaseTest" + driver.toString());
//		} else if (browser==BROWSER.CHROME) {
//			WebDriverManager.chromedriver().setup();
//			//System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
//			//System.setProperty("webdriver.gecko.driver", projectLocation + getDirectorySlash("browserDrivers")+ "chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (browser==BROWSER.EDGE) {
//			WebDriverManager.edgedriver().setup();
//			//System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDrivers\\msedgedriver.exe");
//			//System.setProperty("webdriver.gecko.driver", projectLocation + getDirectorySlash("browserDrivers")+ "msedgedriver.exe");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Please enter browser correct");
//		}
//		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		return driver;
//	}
	
	public WebDriver getBrowserDriver(String browserName, String appURL) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser==BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Driver init at BaseTest" + driver.toString());
		} else if (browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser==BROWSER.EDGE) {
			//System.setProperty("webdriver.edge.driver", projectLocation + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter browser correct");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}
	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

}
