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

public class Login_11_Assert_Verify extends AbstractTest {
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

		verifyTrue(dashboardPage.isActivityCheckboxDisplayed());

		dashboardPage.clickToScreenOption();

		verifyTrue(dashboardPage.isActivityCheckboxDisplayed());
		//fail (hiden)

		verifyTrue(dashboardPage.isAllPostSubMenuDisplayed());
		//fail (not show)
	}

	@Test
	public void TC_02_Element_Undisplayed_Without_In_DOM() {
		verifyFalse(dashboardPage.isPlanMenuUndisplayed());
		//fail 
		
		verifyTrue(dashboardPage.isAllPostSubMenuDisplayed());
		//fail
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
