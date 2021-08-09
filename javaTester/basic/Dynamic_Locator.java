package basic;

public class Dynamic_Locator {

	public static void main(String[] args) {
		String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
		String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	String CUSTOMER_INFO_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
	String DYNAMIC_PAGE_FOOTER= "//div[@class='footer']//a[text()='%s']";
		clickToElement(ORDER_PAGE_FOOTER);
		clickToElement(ORDER_PAGE_FOOTER, "My account");
	}
	
	public static void clickToElement(String locator) {
		System.out.println(locator);
	}
	
	public static void clickToElement(String locator, String pageName) {
		System.out.println(String.format(locator, pageName));
	}
	
	public static void clickToElement(String locator, String pageName, String text) {
		System.out.println(String.format(locator, pageName, text));
	}
	public static void clickToElement(String locator, String... params) {
		System.out.println(String.format(locator,(Object[])params));
	}
}
