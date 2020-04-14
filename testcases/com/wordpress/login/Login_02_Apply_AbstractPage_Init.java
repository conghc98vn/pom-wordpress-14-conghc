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

public class Login_02_Apply_AbstractPage_Init {

	AbstractPage abstractPage;

	WebDriver driver;

//	By emailTextboxBy = By.xpath("//input[@id='usernameOrEmail']");
//	By passwordTextboxBy = By.xpath("//input[@id='password']");
//	By loginButtonBy = By.xpath("//div[@class='login__form-action']/button");
//	By errorMessageBy = By.xpath("//div[@class='form-input-validation is-error']/span");

	String emailTextbox = "//input[@id='usernameOrEmail']";
	String passwordTextbox = "//input[@id='password']";
	String loginButton = "//div[@class='login__form-action']/button";
	String errorMessage = "//div[@class='form-input-validation is-error']/span";

	@BeforeTest
	public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin/");
		abstractPage.openUrl(driver, "https://automationfc.wordpress.com/wp-admin/");
	}

	@Test
	public void TC_01_EmptyEmail() {
//		driver.findElement(emailTextboxBy).sendKeys("");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "");
		abstractPage.clickToElement(driver, loginButton);

		Assert.assertEquals(abstractPage.getElementText(driver, errorMessage), "Please enter a username or email address.");
	}

	@Test
	public void TC_02_InvalidEmail() {
//		driver.findElement(emailTextboxBy).sendKeys("123@123");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "123@123.123");
		abstractPage.clickToElement(driver, loginButton);

		Assert.assertEquals(abstractPage.getElementText(driver, errorMessage), "Please log in using your WordPress.com username instead of your email address.");
	}

	@Test
	public void TC_03_EmailNotExist() {
//		driver.findElement(emailTextboxBy).sendKeys("testnotexist" + randomNumber() + "@test.com");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "abczxc123312@abc.com");
		abstractPage.clickToElement(driver, loginButton);

		Assert.assertEquals(abstractPage.getElementText(driver, errorMessage), "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void TC_04_EmptyPassword() {
//		driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "automationeditor");
		abstractPage.clickToElement(driver, loginButton);

//		driver.findElement(passwordTextboxBy).sendKeys("");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, passwordTextbox, "");
		abstractPage.clickToElement(driver, loginButton);

		Assert.assertEquals(abstractPage.getElementText(driver, errorMessage), "Don't forget to enter your password.");
	}

	@Test
	public void TC_05_PasswordLessThan6Chars() {
//		driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "automationeditor");
		abstractPage.clickToElement(driver, loginButton);

//		driver.findElement(passwordTextboxBy).sendKeys("123");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, passwordTextbox, "123");
		abstractPage.clickToElement(driver, loginButton);

		Assert.assertEquals(abstractPage.getElementText(driver, errorMessage), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_06_IncorrectPassword() {
//		driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "automationeditor");
		abstractPage.clickToElement(driver, loginButton);

//		driver.findElement(passwordTextboxBy).sendKeys("123123");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, passwordTextbox, "123123");
		abstractPage.clickToElement(driver, loginButton);

		Assert.assertEquals(abstractPage.getElementText(driver, errorMessage), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_07_ValidPassword() {
//		driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, emailTextbox, "automationeditor");
		abstractPage.clickToElement(driver, loginButton);

//		driver.findElement(passwordTextboxBy).sendKeys("automationfc");
//		driver.findElement(loginButtonBy).click();
		abstractPage.sendkeyToElement(driver, passwordTextbox, "automationfc");
		abstractPage.clickToElement(driver, loginButton);

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
