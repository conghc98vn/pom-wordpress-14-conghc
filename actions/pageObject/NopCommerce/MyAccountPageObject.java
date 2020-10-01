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

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitForElementVissible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
	}

	public void inputToLastNameTextbox(String lastNameValue) {
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

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVissible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputToCompanyNameTextbox(String companyNameValue) {
		waitForElementVissible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyNameValue);
	}

	public void clickToSaveButton() {
		waitForElementVissible(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public boolean isGenderRaidoButtonSelected(String genderValue) {
		waitForElementVissible(driver, MyAccountPageUI.GENDER_RADIO_BUTTON, genderValue);
		return isElementSelected(driver, MyAccountPageUI.GENDER_RADIO_BUTTON, genderValue);
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
		waitForElementVissible(driver, MyAccountPageUI.DAY_DROPDOWN_TEXT);
		return getElementText(driver, MyAccountPageUI.DAY_DROPDOWN_TEXT);
	}

	public String getDayOfBirthMonthText() {
		waitForElementVissible(driver, MyAccountPageUI.MONTH_DROPDOWN_TEXT);
		return getElementText(driver, MyAccountPageUI.MONTH_DROPDOWN_TEXT);
	}

	public String getDayOfBirthYearText() {
		waitForElementVissible(driver, MyAccountPageUI.YEAR_DROPDOWN_TEXT);
		return getElementText(driver, MyAccountPageUI.YEAR_DROPDOWN_TEXT);
	}

	public String getEmailText() {
		waitForElementVissible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameText() {
		waitForElementVissible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public void clickToAddressButton() {
		waitForElementVissible(driver, MyAccountPageUI.ADDRESSES_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_BUTTON);
	}

	public void clickToAddNewButton() {
		waitForElementVissible(driver, MyAccountPageUI.ADD_NEW_ADDRESSES_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADD_NEW_ADDRESSES_BUTTON);
	}

	public void inputToFirstNameAdressTextbox(String firstNameAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.FIRST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_ADDRESS_TEXTBOX, firstNameAddressValue);
	}

	public void inputToLastNameAdressTextbox(String lastNameAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.LAST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastNameAddressValue);
	}

	public void inputToEmailAddressTextbox(String emailAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddressValue);
	}

	public void inputToCompanyAddressTextbox(String companyAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.COMPANY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_ADDRESS_TEXTBOX, companyAddressValue);
	}

	public void selectCountryAddressDropdown(String countryAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.COUNTRY_ADDRESS_DROPDOWN);
		selectValueInDropdown(driver, MyAccountPageUI.COUNTRY_ADDRESS_DROPDOWN, countryAddressValue);
	}

	public void selectStateProvinceAddressDropdown(String statesProvinceAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.STATE_PROVINCE_ADDRESS_DROPDOWN);
		selectValueInDropdown(driver, MyAccountPageUI.STATE_PROVINCE_ADDRESS_DROPDOWN, statesProvinceAddressValue);
	}

	public void inputToCityAddressTextbox(String cityAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.CITY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CITY_ADDRESS_TEXTBOX, cityAddressValue);
	}

	public void inputToAddress1Textbox(String address1Value) {
		waitForElementVissible(driver, MyAccountPageUI.ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_1_TEXTBOX, address1Value);
	}

	public void inputToAddress2Textbox(String address2Value) {
		waitForElementVissible(driver, MyAccountPageUI.ADDRESS_2_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_2_TEXTBOX, address2Value);
	}

	public void inputToZipPostalCodeAddressTextbox(String zipPostalCodeAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.ZIP_POSTAL_CODE_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ZIP_POSTAL_CODE_ADDRESS_TEXTBOX, zipPostalCodeAddressValue);
	}

	public void inputToPhoneNumberAddressTextbox(String phoneNumberAddressValue) {
		waitForElementVissible(driver, MyAccountPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX, phoneNumberAddressValue);
	}

	public void inputToFaxNumberAddressTextbox(String faxNumberAddressvalue) {
		waitForElementVissible(driver, MyAccountPageUI.FAX_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FAX_NUMBER_ADDRESS_TEXTBOX, faxNumberAddressvalue);
	}

	public void clickToSaveAddressButton() {
		waitForElementVissible(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
	}

	public String getEmailAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.EMAIL_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.EMAIL_ADDRESS_TEXT);
	}

	public String getCompanyAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.COMPANY_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.COMPANY_ADDRESS_TEXT);
	}

	public String getCountryAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.COUNTRY_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.COUNTRY_ADDRESS_TEXT);
	}

	public String getCityAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.CITY_AND_ZIP_POSTAL_CODE_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.CITY_AND_ZIP_POSTAL_CODE_ADDRESS_TEXT);
	}

	public String getAddress1Text() {
		waitForElementsVissible(driver, MyAccountPageUI.ADDRESS_1_TEXT);
		return getElementText(driver, MyAccountPageUI.ADDRESS_1_TEXT);
	}

	public String getAddress2Text() {
		waitForElementsVissible(driver, MyAccountPageUI.ADDRESS_2_TEXT);
		 return getElementText(driver, MyAccountPageUI.ADDRESS_2_TEXT);
	}

	public String getZipPostalCodeAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.CITY_AND_ZIP_POSTAL_CODE_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.CITY_AND_ZIP_POSTAL_CODE_ADDRESS_TEXT);
	}

	public String getPhoneNumberAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.PHONE_NUMBER_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.PHONE_NUMBER_ADDRESS_TEXT);
	}

	public String getFaxNumberAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.FAX_NUMBER_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.FAX_NUMBER_ADDRESS_TEXT);
	}

	public String getFullNameAddressText() {
		waitForElementsVissible(driver, MyAccountPageUI.FULL_NAME_ADDRESS_TEXT);
		return getElementText(driver, MyAccountPageUI.FULL_NAME_ADDRESS_TEXT);
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVissible(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVissible(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, newPassword);		
	}

	public void inputToConfirmPasswordTextbox(String confirmNewPassword) {
		waitForElementVissible(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmNewPassword);	
	}

}
