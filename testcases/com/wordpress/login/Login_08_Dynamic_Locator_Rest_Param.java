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

public class Login_08_Dynamic_Locator_Rest_Param extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGenenratorManagerWordPress.getLoginAdminPage(driver);

		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextbox("automationfc");
		dashboardPage = loginPage.clickToContinueOrLoginButton();
		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@Test
	public void TC_01_Less_Page() {
		postsPage = (PostsPageObject) dashboardPage.openMenuPageByPageName(driver, "Posts");

		pagesPage = (PagesPageObject) postsPage.openMenuPageByPageName(driver, "Pages");

		mediaPage = (MediaPageObject) pagesPage.openMenuPageByPageName(driver, "Media");

		postsPage = (PostsPageObject) mediaPage.openMenuPageByPageName(driver, "Posts");

		pagesPage = (PagesPageObject) postsPage.openMenuPageByPageName(driver, "Pages");

		postsPage = (PostsPageObject) pagesPage.openMenuPageByPageName(driver, "Posts");

		mediaPage = (MediaPageObject) postsPage.openMenuPageByPageName(driver, "Media");

		dashboardPage = (DashboardPageObject) mediaPage.openMenuPageByPageName(driver, "Dashboard");
	}
	

	@Test
	public void TC_02_More_Page() {
		mediaPage.openMenuPageByPageName(driver, "Posts");
		postsPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);

		postsPage.openMenuPageByPageName(driver, "Pages");
		pagesPage = PageGenenratorManagerWordPress.getPagesAdminPage(driver);

		pagesPage.openMenuPageByPageName(driver, "Posts");
		postsPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);

		postsPage.openMenuPageByPageName(driver, "Media");
		mediaPage = PageGenenratorManagerWordPress.getMediaAdminPage(driver);

		mediaPage.openMenuPageByPageName(driver, "Dashboard");
		dashboardPage = PageGenenratorManagerWordPress.getDashboardAdminPage(driver);
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
