package com.bankguru.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.PageGenenratorManager;
import pageObjects.bankGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_04_Dynamic_Page_Element extends AbstractTest{
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userIDValue, passwordValue, loginPageUrl;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "http://demo.guru99.com/v4");
		
		loginPage = PageGenenratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_Register() {
		sleepInSecond(1);
		registerPage = loginPage.clickToHereLink();
		
		registerPage.inputToEmailTextbox("chicong_test" + randomNumber() + "@gmail.com");
		registerPage.clickToSubmitButton();
		userIDValue = registerPage.getUserIDText();
		passwordValue = registerPage.getPasswordText();
		loginPage = registerPage.openLoginPage(loginPageUrl);
	}
	
	@Test
	public void TC_02_Login() {
		loginPage.inputToUserIDTextbox(userIDValue);
		loginPage.inputToPasswordTextbox(passwordValue);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}

	---- Làm tới phút thứ 14
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	
	public void sleepInSecond(long timeouts) {
		try {
			Thread.sleep(timeouts * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
