package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.saucelab.SortPageUI;

public class SortPageObject extends AbstractPage{
	WebDriver driver;
	
	public SortPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String value) {
		waitForElementClickable(driver, SortPageUI.SORT_DROPDOWN);
		selectValueInDropdown(driver, SortPageUI.SORT_DROPDOWN, value);
	}

	public boolean isNameSortAscending() {
		waitForElementsVissible(driver, SortPageUI.PRODUCT_NAME);
		return isDataSortedAscending(driver, SortPageUI.PRODUCT_NAME); 
	}

	public boolean isNameSortDescending() {
		waitForElementsVissible(driver, SortPageUI.PRODUCT_NAME);
		return isDataSortedDecending(driver, SortPageUI.PRODUCT_NAME); 
	}

	public boolean isPriceSortAscending() {
		waitForElementsVissible(driver, SortPageUI.PRODUCT_PRICE);
		return isPriceSortedAscending(driver, SortPageUI.PRODUCT_PRICE); 
	}

	public boolean isPriceSortDescending() {
		waitForElementsVissible(driver, SortPageUI.PRODUCT_PRICE);
		return isPriceSortedDecending(driver, SortPageUI.PRODUCT_PRICE);
	}
	
}
