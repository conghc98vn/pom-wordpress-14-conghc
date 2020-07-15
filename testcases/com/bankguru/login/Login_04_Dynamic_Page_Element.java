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
		loginPage = PageGenenratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_Register() {
		loginPage.clickToDynamicLink(driver, "here");
		registerPage  = PageGenenratorManager.getRegisterPage(driver);
		
		registerPage.inputToDynamicTextbox(driver, "emailid", "chicong_test" + randomNumber() + "@gmail.com");
		registerPage.clickToDynamicButton(driver, "Submit");
		
		userIDValue = registerPage.getDynamicValueByColumnName(driver, "User ID");
		passwordValue = registerPage.getDynamicValueByColumnName(driver, "Password");
		loginPage = registerPage.openLoginPage(loginPageUrl);
	}

	@Test
	public void TC_02_Login() {
		loginPage.inputToDynamicTextbox(driver, "uid", userIDValue);;
		loginPage.inputToDynamicTextbox(driver, "password", passwordValue);
		loginPage.clickToDynamicButton(driver, "LOGIN");
		
		homePage = PageGenenratorManager.getHomePage(driver);
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}

	@Test
	public void TC_03_NewCustomer() {
		homePage.clickToDynamicLink(driver, "New Customer");
		doing---
		
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
	String userIDValue, passwordValue, loginPageUrl;
}
