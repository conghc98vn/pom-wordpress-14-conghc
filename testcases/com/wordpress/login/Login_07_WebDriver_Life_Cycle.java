package com.wordpress.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageFactory.wordpress.DashboardPageObject;
import pageFactory.wordpress.LoginPageObject;
import pageFactory.wordpress.PageGenenratorManager_PageFactory_WordPress;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PagesPageObject;
import pageObjects.wordpress.PostsPageObject;

public class Login_07_WebDriver_Life_Cycle extends AbstractTest {

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driverManager = BrowserDriverFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		loginPage = PageGenenratorManager_PageFactory_WordPress.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_LoginToSystem() {
		loginPage.openLoginPage(loginPageUrl);
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToContinueOrLoginButton();
		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@Test
	public void TC_02_NavigateToPage() {
		// Step 03 - Từ Dashboard -> Post
		postsPage = dashboardPage.clickToPostsMenu(driver);
		// Step 04 - Từ Post -> Page
		pagesPage = postsPage.clickToPagesMenu(driver);
		// Step 05 - Từ Page -> Media
		mediaPage = pagesPage.clickToMediaMenu(driver);
		// Step 06 - Từ Media -> Post
		postsPage = mediaPage.clickToPostsMenu(driver);
		// Step 07 - Từ Post -> Media
		mediaPage = postsPage.clickToMediaMenu(driver);
	}
	@AfterTest
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	String loginPageUrl;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	DriverManager driverManager;
	PostsPageObject postsPage;
	PagesPageObject pagesPage;
	MediaPageObject mediaPage;
	
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
