package com.nopcommerce.register;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObject.NopCommerce.PageGenenratorManager;
import pageObject.NopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_01_Register extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register");

		registerPage = PageGenenratorManager.getRegisterPage(driver);
	}

	@Test
	public void TC_01_Login_With_Data_Empty() {
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirtNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		registerPage.ChooseGenderButton("Male");
		registerPage.inputFirstNameTextbox("Automation");
		registerPage.inputLastNameTextbox("Testing");
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("2020");
		registerPage.inputEmailTextbox("123123123");
		registerPage.inputCompanyNameTextbox("Testing Company");
		registerPage.clickToNewseletterOptionsButton();
		registerPage.inputPasswordTextbox("123456789abc");
		registerPage.inputConfirmPassword("123456789abc");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Register_With_Email_Not_Exists() {
		registerPage.refresh(driver);
		registerPage.ChooseGenderButton("Male");
		registerPage.inputFirstNameTextbox("Automation");
		registerPage.inputLastNameTextbox("Testing");
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("2020");
		registerPage.inputEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputCompanyNameTextbox("Testing Company");
		registerPage.clickToNewseletterOptionsButton();
		registerPage.inputPasswordTextbox("123456789abc");
		registerPage.inputConfirmPassword("123456789abc");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmaiExistslErrorMessage(), "The specified email already exists");
	}

	@Test
	public void TC_04_Register_With_Password_Less_6_Charactor() {
		registerPage.ChooseGenderButton("Male");
		registerPage.inputFirstNameTextbox("Automation");
		registerPage.inputLastNameTextbox("Testing");
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("2020");
		registerPage.inputEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputCompanyNameTextbox("Testing Company");
		registerPage.clickToNewseletterOptionsButton();
		registerPage.inputPasswordTextbox("123");
		registerPage.inputConfirmPassword("123456789abc");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\n" + 
				"must have at least 6 characters");
	}

	@Test
	public void TC_05_Register_With_Password_Do_Not_Match() {
		registerPage.ChooseGenderButton("Male");
		registerPage.inputFirstNameTextbox("Automation");
		registerPage.inputLastNameTextbox("Testing");
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("2020");
		registerPage.inputEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputCompanyNameTextbox("Testing Company");
		registerPage.clickToNewseletterOptionsButton();
		registerPage.inputPasswordTextbox("123123123abc");
		registerPage.inputConfirmPassword("123123123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void TC_06_Register_Valid() {
		registerPage.ChooseGenderButton("Male");
		registerPage.inputFirstNameTextbox("Automation");
		registerPage.inputLastNameTextbox("Testing");
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("2020");
		registerPage.inputEmailTextbox("automationfc.vn" + randomNumber() + "@gmail.com");
		registerPage.inputCompanyNameTextbox("Testing Company");
		registerPage.clickToNewseletterOptionsButton();
		registerPage.inputPasswordTextbox("123123123abc");
		registerPage.inputConfirmPassword("123123123abc");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getMessageRegisterSuccess(),
				"Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	RegisterPageObject registerPage;

}
