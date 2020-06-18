package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObject.NopCommerce.LoginPageObject;
import pageObject.NopCommerce.PageGenenratorManager;
import pageObject.NopCommerce.RegisterPageObject;

public class Login_01_Validate_Login_Form extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login");

		registerPage = PageGenenratorManager.getRegisterPage(driver);
		loginPage = PageGenenratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Login_With_Data_Empty() {
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Email_Invalid() {
		loginPage.inputToEmailTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Account_Not_Exists() {
		loginPage.inputToEmailTextbox("abc15342611@gmail.com");
		loginPage.inputToPasswordTextbox("123123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageLogin(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Login_With_Password_Empty() {
		loginPage.inputToEmailTextbox("abc15342611@gmail.com");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageLogin(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_05_Login_With_Password_Invalid() {
		loginPage.inputToEmailTextbox("abc15342611@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageLogin(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_06_Login_Success() {
		loginPage.inputToEmailTextbox("abc15342611@gmail.com");
		loginPage.inputToPasswordTextbox("123123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageLogin(), "");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	RegisterPageObject registerPage;
	LoginPageObject loginPage;
}
