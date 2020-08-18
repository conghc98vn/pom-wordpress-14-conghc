package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGenenratorManagerWordPress;
import pageObjects.wordpress.admin.DashboardPageObject;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.MediaPageObject;
import pageObjects.wordpress.admin.PagesPageObject;
import pageObjects.wordpress.admin.PostsPageObject;

public class Login_07_WebDriver_LifeCycle extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGenenratorManagerWordPress.getLoginAdminPage(driver);
	}

	@Test
	public void TC_01_LoginToSystem() {
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("automationfc");
		dashboardPage = loginPage.clickToContinueOrLoginButton();
		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@Test
	public void TC_02_NavigateToPage() {
		// Step 03 Dashboard -> Posts
		postsPage = dashboardPage.clickToPostsMenu(driver);
		// Step 04 Posts -> Pages
		pagesPage = postsPage.clickToPagesMenu(driver);
		// Step 05 Pages -> Media
		mediaPage = pagesPage.clickToMediaMenu(driver);
		// Step 06 Media -> Posts
		postsPage = mediaPage.clickToPostsMenu(driver);
//		// Step 07 Posts -> Pages
		pagesPage = postsPage.clickToPagesMenu(driver);
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
