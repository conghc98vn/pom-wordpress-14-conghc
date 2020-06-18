package pageObject.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.NopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderRadioButton(String genderValue) {
		waitForElementVissible(driver, MyAccountPageUI.GENDER_RADIO_BUTTON, genderValue);
		clickToElement(driver, MyAccountPageUI.GENDER_RADIO_BUTTON, genderValue);
	}

	public void inputFirstNameTextbox(String firstNameValue) {
		waitForElementVissible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
	}

	public void inputLastNameTextbox(String lastNameValue) {
		waitForElementVissible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastNameValue);
	}

	public void selectDayDropdown(String dayValue) {
		waitForElementVissible(driver, MyAccountPageUI.DAY_DROPDOWN);
		selectValueInDropdown(driver, MyAccountPageUI.DAY_DROPDOWN, dayValue);
	}

	public void selectMonthDropdown(String monthValue) {
		waitForElementVissible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		selectValueInDropdown(driver, MyAccountPageUI.MONTH_DROPDOWN, monthValue);
	}

	public void selectYearDropdown(String yearValue) {
		waitForElementVissible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		selectValueInDropdown(driver, MyAccountPageUI.YEAR_DROPDOWN, yearValue);
	}

	public void inputEmailTextbox(String emailValue) {
		waitForElementVissible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputCompanyName(String companyNameValue) {
		waitForElementVissible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyNameValue);
	}

	public void clickToSaveButton() {
		waitForElementVissible(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public boolean isGenderRaidoButtonSelected(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getFirstNameText() {
		waitForElementVissible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameText() {
		waitForElementVissible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getDayOfBirthDayText() {
		waitForElementVissible(driver, MyAccountPageUI.DAY_DROPDOWN);
		return getElementAttribute(driver, MyAccountPageUI.DAY_DROPDOWN, "value");
	}

	public String getDayOfBirthMonthText() {
		waitForElementVissible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		return getElementAttribute(driver, MyAccountPageUI.MONTH_DROPDOWN, "value");
	}

	public String getDayOfBirthYearText() {
		waitForElementVissible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		return getElementAttribute(driver, MyAccountPageUI.YEAR_DROPDOWN, "value");
	}

	public String getEmailText() {
		waitForElementVissible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameText() {
		waitForElementVissible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, "value");
	}
}
