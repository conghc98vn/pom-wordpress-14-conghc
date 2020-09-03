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

public class Regiser_02_Data_TestNG_XML extends AbstractTest{
	WebDriver driver;
//	public static String email = "automationfc.vn" + randomNumber() + "@gmail.com";

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register");

		registerPage = PageGenenratorManager.getRegisterPage(driver);
		
		data = DataHelper.getData();
	}

	@Parameters({"firstname", "lastname", "email", "company", "password"})
	@Test
	public void TC_01_Register_Valid(String firstName, String lastName, String email, String companyName, String password) {
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
}
