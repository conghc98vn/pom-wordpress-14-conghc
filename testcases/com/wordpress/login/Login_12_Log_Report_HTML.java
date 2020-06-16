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

public class Login_12_Log_Report_HTML extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		log.info("Pre-condition - STEP 01: Open Login page");
		loginPage = PageGenenratorManager.getLoginPage(driver);

		log.info("Pre-condition - STEP 02: Input to 'Email' textbox");
		loginPage.inputToEmailTextbox("automationeditor");

		log.info("Pro-condition - STEP 03: Click to 'Continue' button");
		loginPage.clickToContinueOrLoginButton();

		log.info("Pre-condition - STEP 04: Input to 'Password' textbox");
		loginPage.inputToPasswordTextbox("automationfc");

		log.info("Pre-condition - STEP 05: Click to 'Login' button");
		dashboardPage = loginPage.clickToContinueOrLoginButton();

		log.info("Pre-condition - STEP 06: Verify header text is displayed");
		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@Test
	public void TC_01_New_Customer() {
		log.info("New Customer - STEP 01: Click to 'Screen' option");
		dashboardPage.clickToScreenOption();

		log.info("New Customer - STEP 02: Verify 'Activity' checkbox is displayed");
		verifyTrue(dashboardPage.isActivityCheckboxDisplayed());

		log.info("New Customer - STEP 01: Click to 'Screen' option");
		dashboardPage.clickToScreenOption();

		log.info("New Customer - STEP 01: Verify 'Activity' checkbox is not displayed");
		verifyFalse(dashboardPage.isActivityCheckboxDisplayed());

		log.info("New Customer - STEP 01: Verify 'All Posts' checkbox is not displayed");
		verifyTrue(dashboardPage.isAllPostSubMenuDisplayed());
	}

	@AfterTest
	public void afterClass() {
		log.info("Post-Condition - Close browser");
		driver.quit();
	}

	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	PostsPageObject postsPage;
	MediaPageObject mediaPage;
	PagesPageObject pagesPage;
}
