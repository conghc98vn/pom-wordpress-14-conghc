package com.bankguru.login;

import org.testng.annotations.Test;

import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_RegisterAndLogin {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userIDValue, passwordValue, loginPageUrl;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/v4");
		
		loginPage = new LoginPageObject(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_Register() {
		sleepInSecond(1);
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToEmailTextbox("chicong_test" + randomNumber() + "@gmail.com");
		registerPage.clickToSubmitButton();
		userIDValue = registerPage.getUserIDText();
		passwordValue = registerPage.getPasswordText();
		registerPage.openLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver);
	}
	
	@Test
	public void TC_02_Login() {
		loginPage.inputToUserIDTextbox(userIDValue);
		loginPage.inputToPasswordTextbox(passwordValue);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	public void sleepInSecond(long timeouts) {
		try {
			Thread.sleep(timeouts * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
