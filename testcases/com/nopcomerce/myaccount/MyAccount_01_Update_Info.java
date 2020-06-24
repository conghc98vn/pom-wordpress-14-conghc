package com.nopcomerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.register.Register_01_Validate_Register_Form;

import commons.AbstractTest;
import pageObject.NopCommerce.LoginPageObject;
import pageObject.NopCommerce.MyAccountPageObject;
import pageObject.NopCommerce.PageGenenratorManager;
import pageObject.NopCommerce.RegisterPageObject;

public class MyAccount_01_Update_Info extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register");
		// Register new Account
		registerPage = PageGenenratorManager.getRegisterPage(driver);
		registerPage.ChooseGenderButton("Male");
		registerPage.inputFirstNameTextbox("Automation");
		registerPage.inputLastNameTextbox("Testing");
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("2020");
		registerPage.inputEmailTextbox(Register_01_Validate_Register_Form.email);
		registerPage.inputCompanyNameTextbox("Testing Company");
		registerPage.clickToNewseletterOptionsButton();
		registerPage.inputPasswordTextbox(Register_01_Validate_Register_Form.password);
		registerPage.inputConfirmPassword(Register_01_Validate_Register_Form.password);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getMessageRegisterSuccess(), "Your registration completed");

		registerPage.sleepInSecond(2);
		myAccountPage = registerPage.clickToMyAccountButton(driver);
	}

//	@Test
	public void TC_01_Update_Customer_Info() {
		myAccountPage.clickToGenderRadioButton("female");
		myAccountPage.inputToFirstNameTextbox("Automation");
		myAccountPage.inputToLastNameTextbox("FC");
		myAccountPage.selectDayDropdown("1");
		myAccountPage.selectMonthDropdown("January");
		myAccountPage.selectYearDropdown("1999");
		myAccountPage.inputToEmailTextbox("automationfc.vn2@gmail.com");
		myAccountPage.inputToCompanyNameTextbox("Automation FC");
		myAccountPage.clickToSaveButton();

		verifyTrue(myAccountPage.isGenderRaidoButtonSelected("female"));
		verifyEquals((String) myAccountPage.getFirstNameText(), "Automation");
		verifyEquals((String) myAccountPage.getLastNameText(), "FC");
		verifyEquals((String) myAccountPage.getDayOfBirthDayText(), "1");
		verifyEquals((String) myAccountPage.getDayOfBirthMonthText(), "January");
		verifyEquals((String) myAccountPage.getDayOfBirthYearText(), "1999");
		verifyEquals((String) myAccountPage.getEmailText(), "automationfc.vn2@gmail.com");
		verifyEquals((String) myAccountPage.getCompanyNameText(), "Automation FC");
		myAccountPage.sleepInSecond(3);
	}

	@Test
	public void TC_02_Add_New_Address() {
		myAccountPage.clickToAddressButton();
		myAccountPage.clickToAddNewButton();
		myAccountPage.inputToFirstNameAdressTextbox("Automation");
		myAccountPage.inputToLastNameAdressTextbox("FC");
		myAccountPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		myAccountPage.inputToCompanyAddressTextbox("Automation FC");
		myAccountPage.selectCountryAddressDropdown("Viet Nam");
		myAccountPage.selectStateProvinceAddressDropdown("Other");
		myAccountPage.inputToCityAddressTextbox("Da Nang");
		myAccountPage.inputToAddress1Textbox("123/04 Le Lai");
		myAccountPage.inputToAddress2Textbox("234/05 Hai Phong");
		myAccountPage.inputToZipPostalCodeAddressTextbox("550000");
		myAccountPage.inputToPhoneNumberAddressTextbox("0123456789");
		myAccountPage.inputToFaxNumberAddressTextbox("0987654321");
		myAccountPage.clickToSaveAddressButton();

		verifyTrue(myAccountPage.getFullNameAddressText().contains("Automation FC"));
		verifyTrue(myAccountPage.getEmailAddressText().contains("automationfc.vn@gmail.com"));
		verifyTrue(myAccountPage.getCompanyAddressText().contains("Automation FC"));
		verifyTrue(myAccountPage.getCountryAddressText().contains("Viet Nam"));
		verifyTrue(myAccountPage.getCityAddressText().contains("Da Nang"));
		verifyTrue(myAccountPage.getAddress1Text().contains("123/04 Le Lai"));
		verifyTrue(myAccountPage.getAddress2Text().contains("234/05 Hai Phong"));
		verifyTrue(myAccountPage.getZipPostalCodeAddressText().contains("550000"));
		verifyTrue(myAccountPage.getPhoneNumberAddressText().contains("0123456789"));
		verifyTrue(myAccountPage.getFaxNumberAddressText().contains("0987654321"));
	}

//	@Test
	public void TC_03_Update_New_Password() {
	}

//	@Test
	public void TC_04_Add_New_Review() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
//		driver.quit();
	}

	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
}
