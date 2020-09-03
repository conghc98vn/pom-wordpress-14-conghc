package com.nopcommerce.endUser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.EndUserJson;

import commons.AbstractTest;
import commons.GlobalConstans;
import pageObject.NopCommerce.PageGenenratorManager;
import pageObject.NopCommerce.RegisterPageObject;

public class Regiser_04_Data_In_Class extends AbstractTest {
	WebDriver driver;
//	public static String email = "automationfc.vn" + randomNumber() + "@gmail.com";

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register");

		registerPage = PageGenenratorManager.getRegisterPage(driver);
		
		data = EndUserJson.getEndUserData(GlobalConstans.ROOT_FOLDER + "\\testdata\\com\\nopcommerce\\data\\Register.json");
		
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
	EndUserJson data;
	String firstName, lastName, email, companyName, password;
}
