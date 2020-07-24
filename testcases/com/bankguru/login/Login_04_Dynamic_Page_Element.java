package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.bankGuru.EditCusomterPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGenenratorManager;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_04_Dynamic_Page_Element extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "http://demo.guru99.com/v4");

		customerName = "Ryan Giggs";
		gender = "male";
		dateOfBirth = "1970-06-01";
		address = "234 Address";
		city = "California";
		state = "New York";
		pin = "123456";
		phone = "0987654321";
		email = "ryan_giggs" + randomNumber() + "@gmail.com";

		editAddress = "123 Le Trong Tan";
		editCity = "Ho Chi Minh";
		editState = "Tan Phu";
		editPin = "600000";
		editPhone = "0987654321";
		editEmail = "giggs_updated" + randomNumber() + "@gmail.com";

		loginPage = PageGenenratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_Register() {
		loginPage.clickToDynamicLink(driver, "here");
		registerPage = PageGenenratorManager.getRegisterPage(driver);

		registerPage.inputToDynamicTextbox(driver, "emailid", email);
		registerPage.clickToDynamicButton(driver, "Submit");

		userIDValue = registerPage.getDynamicValueByColumnName(driver, "User ID");
		passwordValue = registerPage.getDynamicValueByColumnName(driver, "Password");
		loginPage = registerPage.openLoginPage(loginPageUrl);
	}

	@Test
	public void TC_02_Login() {
		loginPage.inputToDynamicTextbox(driver, "uid", userIDValue);
		;
		loginPage.inputToDynamicTextbox(driver, "password", passwordValue);
		loginPage.clickToDynamicButton(driver, "LOGIN");

		homePage = PageGenenratorManager.getHomePage(driver);
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}

	@Test
	public void TC_03_NewCustomer() {
		homePage.clickToDynamicLink(driver, "New Customer");
		newCustomerPage = PageGenenratorManager.getNewCustomerPage(driver);

		// input data to require
		newCustomerPage.inputToDynamicTextbox(driver, "name", customerName);
		newCustomerPage.clickToDynamicRadioButton(driver, "m");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", dateOfBirth);
		newCustomerPage.inputToDynamicTextArea(driver, "addr", address);
		newCustomerPage.inputToDynamicTextbox(driver, "city", city);
		newCustomerPage.inputToDynamicTextbox(driver, "state", state);
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", pin);
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", phone);
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", email);
		newCustomerPage.inputToDynamicTextbox(driver, "password", passwordValue);
		newCustomerPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(newCustomerPage.isDynamicMessageDisplayed(driver, "Customer Registered Successfully!!!"));

		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Address"), address);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "City"), city);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "State"), state);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Mobile No."), phone);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver, "Email"), email);
		newCustomerID = newCustomerPage.getDynamicValueByColumnName(driver, "Customer ID");
	}

	@Test
	public void TC_04_EditCustomer() {
		newCustomerPage.clickToDynamicLink(driver, "Edit Customer");
		editCustomerPage = PageGenenratorManager.getEditCustomerPage(driver);
		
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", newCustomerID);
		editCustomerPage.clickToDynamicButton(driver, "Submit");

		// input data to require
		editCustomerPage.inputToDynamicTextArea(driver, "addr", editAddress);
		editCustomerPage.inputToDynamicTextbox(driver, "city", editCity);
		editCustomerPage.inputToDynamicTextbox(driver, "state", editState);
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", editPin);
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", editPhone);
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", editEmail);
		editCustomerPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(newCustomerPage.isDynamicMessageDisplayed(driver, "Customer details updated Successfully!!!"));

		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Gender"), gender);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Birthdate"), dateOfBirth);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Address"), editAddress);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "City"), editCity);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "State"), editState);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Pin"), editPin);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Mobile No."), editPhone);
		verifyEquals(editCustomerPage.getDynamicValueByColumnName(driver, "Email"), editEmail);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCusomterPageObject editCustomerPage;
	String userIDValue, passwordValue, loginPageUrl, newCustomerID;
	String customerName, gender, dateOfBirth, address, city, state, pin, phone, email;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;
}
