package com.wordpress.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageFactory.wordpress.DashboardPageObject;
import pageFactory.wordpress.LoginPageObject;
import pageFactory.wordpress.PageGenenratorManager_PageFactory_WordPress;

public class Login_06_Browser_Factory_Pattern extends AbstractTest {
	WebDriver driver;
	String loginPageUrl;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	DriverManager driverManager;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driverManager = BrowserDriverFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		
		loginPage = PageGenenratorManager_PageFactory_WordPress.getLoginPage(driver);
		
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@BeforeMethod
	public void BeforeMethod() {
//		openUrl(driver, "https://automationfc.wordpress.com/wp-admin/");

	}

	@Test
	public void TC_01_EmptyEmail() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(), "Please enter a username or email address.");
	}

	@Test
	public void TC_02_InvalidEmail() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("123@123.123");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(), "Please log in using your WordPress.com username instead of your email address.");
	}

	@Test
	public void TC_03_EmailNotExist() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("abczxc123312@abc.com");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(), "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void TC_04_EmptyPassword() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(), "Don't forget to enter your password.");
	}

	@Test
	public void TC_05_PasswordLessThan6Chars() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_06_IncorrectPassword() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("123abc");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_07_ValidPassword() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToContinueOrLoginButton();
		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
