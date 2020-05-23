package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PageGenenratorManager;
import pageObjects.wordpress.PagesPageObject;
import pageObjects.wordpress.PostsPageObject;

public class Login_07_WebDriver_LifeCycle extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGenenratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_LoginToSystem() {
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToContinueOrLoginButton();
		dashboardPage = new DashboardPageObject(driver);
//		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@Test
	public void TC_02_NavigateToPage() {
		// Step 03 Dashboard -> Posts
		postsPage = dashboardPage.clickToPostsMenu();
		// Step 04 Posts -> Pages
		pagesPage = postsPage.clickToPagesMenu();
		// Step 05 Pages -> Media
		mediaPage = pagesPage.clickToMediaMenu();
		// Step 06 Media -> Posts
//		postsPage = mediaPage.clickToPostsMenu();
//		// Step 07 Posts -> Pages
//		dashboard = postsPage.clickToPagesMenu();
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	PostsPageObject postsPage;
	MediaPageObject mediaPage;
	PagesPageObject pagesPage;
}
