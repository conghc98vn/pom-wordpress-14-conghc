package com.nopcommerce.endUser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.DataHelper;
import pageObject.NopCommerce.PageGenenratorManager;
import pageObject.NopCommerce.RegisterPageObject;

public class Regiser_01_Data_Driven extends AbstractTest{
	WebDriver driver;
//	public static String email = "automationfc.vn" + randomNumber() + "@gmail.com";

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register");

		registerPage = PageGenenratorManager.getRegisterPage(driver);
		
		data = DataHelper.getData();
		
		firstName = data.getFirstName();
		lastName = data.getLastName();
		email = data.getEmail();
		companyName = data.getCompanyName();
		password = data.getPassword();
	}

	@Test
	public void TC_01_Register_Valid() {
		registerPage.inputFirstNameTextbox(firstName);
		registerPage.inputLastNameTextbox(lastName);
		registerPage.inputEmailTextbox(email);
		registerPage.inputCompanyNameTextbox(companyName);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPassword(password);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	RegisterPageObject registerPage;
	DataHelper data;
	String firstName, lastName, email, companyName, password;
}
