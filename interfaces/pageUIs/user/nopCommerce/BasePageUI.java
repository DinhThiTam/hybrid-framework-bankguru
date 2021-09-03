package pageUIs.user.nopCommerce;

public class BasePageUI {
	public static final String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
	public static final String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	public static final String CUSTOMER_INFO_PAGE_FOOTER= "//div[@class='footer']//a[text()='My account']";
	
	public static final String DYNAMIC_PAGE_FOOTER= "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//a[text() = '%s']";
	public static final String DYNAMIC_GENDER_RADIO = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON = "//button[text()='%s']";
}
