package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.InventoryPageUI;

public class InventoryPO extends BasePage{
	WebDriver driver;

	public InventoryPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, InventoryPageUI.PRODUCT_SORT_DROPDOWN);
		selectDropdownByText(driver, InventoryPageUI.PRODUCT_SORT_DROPDOWN, itemText);		
	}

	public boolean isProductNameSortAscending() {
		List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME);
		List<String> productNameText = new ArrayList<String>();
		
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME);
		List<String> productNameText = new ArrayList<String>();
		
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		
		System.out.println("Before sort:---------");
		for (String product:productNameText) {
			System.out.println(product);
		}
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		
		System.out.println("After sort:---------");
		for (String product:productNameText) {
			System.out.println(product);
		}
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isPriceSortAscending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE);
		List<Float> productNamePrice = new ArrayList<Float>();
		
		for (WebElement productPrice : productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", ""));
			productNamePrice.add(productPriceNumber);
		}
		
		List<Float> productNamePriceClone = new ArrayList<Float>(productNamePrice);
		Collections.sort(productNamePriceClone);
		return productNamePrice.equals(productNamePriceClone);
	}

	public boolean isPriceSortDescending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE);
		List<Float> productNamePrice = new ArrayList<Float>();
		
		for (WebElement productPrice : productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", ""));
			productNamePrice.add(productPriceNumber);
		}
		
		List<Float> productNamePriceClone = new ArrayList<Float>(productNamePrice);
		Collections.sort(productNamePriceClone);
		Collections.reverse(productNamePriceClone);
		return productNamePrice.equals(productNamePriceClone);
	}
	

}
