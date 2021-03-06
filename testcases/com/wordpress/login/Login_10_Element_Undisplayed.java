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

public class Login_10_Element_Undisplayed extends AbstractTest {
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

//	@Test
	public void TC_01_Element_Undisplayed_In_DOM() {
		dashboardPage.clickToScreenOption();

		System.out.println("Start check Activity checkbox displayed: " + getDateTimeNow());
		Assert.assertTrue(dashboardPage.isActivityCheckboxDisplayed());
		System.out.println("End check Activity checkbox displayed: " + getDateTimeNow());

		dashboardPage.clickToScreenOption();

		System.out.println("Start check Activity checkbox not displayed: " + getDateTimeNow());
		Assert.assertFalse(dashboardPage.isActivityCheckboxDisplayed());
		System.out.println("End check Activity checkbox displayed: " + getDateTimeNow());

		System.out.println("Start check All Post not displayed: " + getDateTimeNow());
		Assert.assertFalse(dashboardPage.isAllPostSubMenuDisplayed());
		System.out.println("End check All Post not displayed: " + getDateTimeNow());
	}

	@Test
	public void TC_02_Element_Undisplayed_Without_In_DOM() {
		System.out.println("Start check Plans Link not displayed: " + getDateTimeNow());
		Assert.assertTrue(dashboardPage.isPlanMenuUndisplayed());
		System.out.println("End check Plans Link not displayed: " + getDateTimeNow());
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
