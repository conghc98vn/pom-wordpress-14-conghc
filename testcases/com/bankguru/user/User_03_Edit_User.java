package com.bankguru.user;

import org.testng.annotations.Test;

import com.bankguru.common.Common_01_Register;

import commons.AbstractTest;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_03_Edit_User extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userIDValue, passwordValue, loginPageUrl;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "http://demo.guru99.com/v4");

		loginPage = new LoginPageObject(driver);
		loginPage.inputToUserIDTextbox(Common_01_Register.userIDValue);
		loginPage.inputToPasswordTextbox(Common_01_Register.passwordValue);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}

	@Test
	public void TC_01_Edit_Name() {

	}

	@Test
	public void TC_02_Edit_Address() {

	}

	@Test
	public void TC_03_Edit_Phone() {

	}

	@Test
	public void TC_04_Edit_City() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
