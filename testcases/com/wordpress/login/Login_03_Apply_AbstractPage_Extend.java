package com.wordpress.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Login_03_Apply_AbstractPage_Extend extends AbstractPage {

	WebDriver driver;

	String emailTextbox = "//input[@id='usernameOrEmail']";
	String passwordTextbox = "//input[@id='password']";
	String loginButton = "//div[@class='login__form-action']/button";
	String errorMessage = "//div[@class='form-input-validation is-error']/span";

	@BeforeTest
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void BeforeMethod() {
		openUrl(driver, "https://automationfc.wordpress.com/wp-admin/");
	}

	@Test
	public void TC_01_EmptyEmail() {
		sendkeyToElement(driver, emailTextbox, "");
		clickToElement(driver, loginButton);
		Assert.assertEquals(getElementText(driver, errorMessage), "Please enter a username or email address.");
	}

	@Test
	public void TC_02_InvalidEmail() {
		sendkeyToElement(driver, emailTextbox, "123@123.123");
		clickToElement(driver, loginButton);
		Assert.assertEquals(getElementText(driver, errorMessage), "Please log in using your WordPress.com username instead of your email address.");
	}

	@Test
	public void TC_03_EmailNotExist() {
		sendkeyToElement(driver, emailTextbox, "abczxc123312@abc.com");
		clickToElement(driver, loginButton);
		Assert.assertEquals(getElementText(driver, errorMessage), "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void TC_04_EmptyPassword() {
		sendkeyToElement(driver, emailTextbox, "automationeditor");
		clickToElement(driver, loginButton);
		sendkeyToElement(driver, passwordTextbox, "");
		clickToElement(driver, loginButton);
		Assert.assertEquals(getElementText(driver, errorMessage), "Don't forget to enter your password.");
	}

	@Test
	public void TC_05_PasswordLessThan6Chars() {
		sendkeyToElement(driver, emailTextbox, "automationeditor");
		clickToElement(driver, loginButton);
		sendkeyToElement(driver, passwordTextbox, "123");
		clickToElement(driver, loginButton);
		Assert.assertEquals(getElementText(driver, errorMessage), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_06_IncorrectPassword() {
		sendkeyToElement(driver, emailTextbox, "automationeditor");
		clickToElement(driver, loginButton);
		sendkeyToElement(driver, passwordTextbox, "123123");
		clickToElement(driver, loginButton);
		Assert.assertEquals(getElementText(driver, errorMessage), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_07_ValidPassword() {
		sendkeyToElement(driver, emailTextbox, "automationeditor");
		clickToElement(driver, loginButton);
		sendkeyToElement(driver, passwordTextbox, "automationfc");
		clickToElement(driver, loginButton);
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Dashboard");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dashboard-widgets-wrap']")).isDisplayed());
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
