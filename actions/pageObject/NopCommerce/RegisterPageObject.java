package pageObject.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.NopCommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementVissible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public void ChooseGenderButton(String genderValue) {
		waitForElementVissible(driver, RegisterPageUI.CHOOSEGENDERBUTTON, genderValue);
		clickToElement(driver, RegisterPageUI.CHOOSEGENDERBUTTON, genderValue);
	}

	public void inputFirstNameTextbox(String firstNameValue) {
		waitForElementVissible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
	}

	public void inputLastNameTextbox(String lastNameValue) {
		waitForElementVissible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
	}

	public void selectDayDropdown(String dayValue) {
		waitForElementVissible(driver, RegisterPageUI.SELECT_DAY_DROPDOWN);
		selectValueInDropdown(driver, RegisterPageUI.SELECT_DAY_DROPDOWN, dayValue);
	}

	public void selectMonthDropdown(String monthValue) {
		waitForElementVissible(driver, RegisterPageUI.SELECT_MONTH_DROPDOWN);
		selectValueInDropdown(driver, RegisterPageUI.SELECT_MONTH_DROPDOWN, monthValue);
	}

	public void selectYearDropdown(String yearValue) {
		waitForElementVissible(driver, RegisterPageUI.SELECT_YEAR_DROPDOWN);
		selectValueInDropdown(driver, RegisterPageUI.SELECT_YEAR_DROPDOWN, yearValue);
	}

	public void inputEmailTextbox(String emailValue) {
		waitForElementVissible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputCompanyNameTextbox(String companyNameValue) {
		waitForElementVissible(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX, companyNameValue);
	}

	public void clickToNewseletterOptionsButton() {
		waitForElementVissible(driver, RegisterPageUI.NEWSELETTER_OPTIONS_BUTTON);
		clickToElement(driver, RegisterPageUI.NEWSELETTER_OPTIONS_BUTTON);
	}

	public void inputPasswordTextbox(String passwordValue) {
		waitForElementVissible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void inputConfirmPassword(String passwordConfirmValue) {
		waitForElementVissible(driver, RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX, passwordConfirmValue);
	}

	public String getFirtNameErrorMessage() {
		waitForElementVissible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE_TEXT);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE_TEXT);
	}

	public String getLastNameErrorMessage() {
		waitForElementVissible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXT);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXT);
	}

	public String getEmailErrorMessage() {
		waitForElementVissible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE_TEXT);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE_TEXT);
	}

	public String getPasswordErrorMessage() {
		waitForElementVissible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXT);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVissible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT);
	}

	public String getEmaiExistslErrorMessage() {
		waitForElementVissible(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE_TEXT);
		return getElementText(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE_TEXT);
	}

	public String getMessageRegisterSuccess() {
		waitForElementVissible(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESS_TEXT);
		return getElementText(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESS_TEXT);
	}

	public void clickToCountinueButton() {
		waitForElementVissible(driver, RegisterPageUI.COUNTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.COUNTINUE_BUTTON);		
	}

}
