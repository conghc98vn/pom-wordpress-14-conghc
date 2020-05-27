package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Login_08_Dynamic_Locator_Rest_Param extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGenenratorManager.getLoginPage(driver);

		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("automationfc");
		dashboardPage = loginPage.clickToContinueOrLoginButton();
		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@Test
	public void TC_01_Less_Page() {
		postsPage = (PostsPageObject) dashboardPage.clickToLessDynamicPageMenu(driver, "Posts");

		pagesPage = (PagesPageObject) postsPage.clickToLessDynamicPageMenu(driver, "Pages");

		mediaPage = (MediaPageObject) pagesPage.clickToLessDynamicPageMenu(driver, "Media");

		postsPage = (PostsPageObject) mediaPage.clickToLessDynamicPageMenu(driver, "Posts");

		pagesPage = (PagesPageObject) postsPage.clickToLessDynamicPageMenu(driver, "Pages");

		postsPage = (PostsPageObject) pagesPage.clickToLessDynamicPageMenu(driver, "Posts");

		mediaPage = (MediaPageObject) postsPage.clickToLessDynamicPageMenu(driver, "Media");

		dashboardPage = (DashboardPageObject) mediaPage.clickToLessDynamicPageMenu(driver, "Dashboard");
	}
	

	@Test
	public void TC_02_More_Page() {
		mediaPage.clickToLessDynamicPageMenu(driver, "Posts");
		postsPage = PageGenenratorManager.getPostsPage(driver);

		postsPage.clickToLessDynamicPageMenu(driver, "Pages");
		pagesPage = PageGenenratorManager.getPagesPage(driver);

		pagesPage.clickToLessDynamicPageMenu(driver, "Posts");
		postsPage = PageGenenratorManager.getPostsPage(driver);

		postsPage.clickToLessDynamicPageMenu(driver, "Media");
		mediaPage = PageGenenratorManager.getMediaPage(driver);

		mediaPage.clickToLessDynamicPageMenu(driver, "Dashboard");
		dashboardPage = PageGenenratorManager.getDashboardPage(driver);
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
