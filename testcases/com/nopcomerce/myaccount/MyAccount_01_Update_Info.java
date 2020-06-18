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

	@Test
	public void TC_01_Update_Customer_Info() {
		myAccountPage.clickToGenderRadioButton("female");
		myAccountPage.inputFirstNameTextbox("Automation");
		myAccountPage.inputLastNameTextbox("FC");
		myAccountPage.selectDayDropdown("1");
		myAccountPage.selectMonthDropdown("January");
		myAccountPage.selectYearDropdown("1999");
		myAccountPage.inputEmailTextbox("automationfc.vn2@gmail.com");
		myAccountPage.inputCompanyName("Automation FC");
		myAccountPage.clickToSaveButton();

		// Verify - update thêm verify ngày tháng năm
		verifyTrue(myAccountPage.isGenderRaidoButtonSelected("female"));
		verifyEquals((String)myAccountPage.getFirstNameText(), "Automation");
		verifyEquals((String)myAccountPage.getLastNameText(), "FC");
//		verifyEquals((String)myAccountPage.getDayOfBirthDayText(), "1");
//		verifyEquals((String)myAccountPage.getDayOfBirthMonthText(), "January");
//		verifyEquals((String)myAccountPage.getDayOfBirthYearText(), "1999");
		verifyEquals((String)myAccountPage.getEmailText(), "automationfc.vn2@gmail.com");
		verifyEquals((String)myAccountPage.getCompanyNameText(), "Automation FC");
	}

//	@Test
	public void TC_02_Add_New_Address() {
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
