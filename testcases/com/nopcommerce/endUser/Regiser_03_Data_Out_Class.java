package com.nopcommerce.endUser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.EndUser;

import commons.AbstractTest;
import pageObject.NopCommerce.PageGenenratorManager;
import pageObject.NopCommerce.RegisterPageObject;

public class Regiser_03_Data_Out_Class extends AbstractTest {
	WebDriver driver;
//	public static String email = "automationfc.vn" + randomNumber() + "@gmail.com";

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register");

		registerPage = PageGenenratorManager.getRegisterPage(driver);
				
		firstName = EndUser.Register.FIRST_NAME;
		lastName = EndUser.Register.LAST_NAME;
		email = EndUser.Register.EMAIL;
		companyName = EndUser.Register.COMPANY_NAME;
		password = EndUser.Register.PASSWROD;
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
	String firstName, lastName, email, companyName, password;
}
