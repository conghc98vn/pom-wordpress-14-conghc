package pageObject.jquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.jquery.DataTablePageUI;

public class DataTablePageObject extends AbstractPage {
	WebDriver driver;

	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnByName(String columnName, String value) {
		waitForElementVissible(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, columnName);
		sendkeyToElement(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, value, columnName);
		sendKeyboardToElement(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, Keys.ENTER, columnName);
		sleepInSecond(2);
	}

	public boolean isOnlyRowDisplayed(String textValue) {
		waitForElementVissible(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, textValue);
		// 1 - Duy nhất 1 row
		int rowNumber = countElementNumber(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, textValue);

		// 2 - Text tìm kiếm hiển thị trong row
		boolean status = isElementDisplay(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, textValue);

		return rowNumber == 1 && status;
	}

	public void clickToEditOrDeleteIconByCountry(String countryValue, String actionName) {
		waitForElementVissible(driver, DataTablePageUI.DYNAMIC_EDIT_OR_DELETE_ICON_BY_CONNTRY, countryValue,
				actionName);
		clickToElement(driver, DataTablePageUI.DYNAMIC_EDIT_OR_DELETE_ICON_BY_CONNTRY, countryValue, actionName);
	}

	public void navigateToPageNumberByIndex(String pageNumber) {
		waitForElementVissible(driver, DataTablePageUI.DYNAMIC_PAGE_BY_INDEX, pageNumber);
		clickToElement(driver, DataTablePageUI.DYNAMIC_PAGE_BY_INDEX, pageNumber);
	}

	public boolean isPageActiveByIndex(String pageNumber) {
		waitForElementVissible(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVED_BY_INDEX, pageNumber);
		boolean status = isElementDisplay(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVED_BY_INDEX, pageNumber);
		return status;
	}

	public void inputToDynamicTextboxAtRowNumber(String columnName, String rowNumber, String inputValue) {
		waitForElementVissible(driver, DataTablePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName);
		int columnPosition = countElementNumber(driver, DataTablePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName) + 1;
		
		sendkeyToElement(driver, DataTablePageUI.DYNAMIC_TEXTBOX_BY_COMLUMN_AND_ROW_INDEX, inputValue, rowNumber, String.valueOf(columnPosition));
	}

}
