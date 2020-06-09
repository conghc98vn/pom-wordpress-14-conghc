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

public class Login_09_Upload_Multiple_Files extends AbstractTest {
	WebDriver driver;

	String iosName = "ios.jpg	";
	String windowsphoneName = "windowsphone.jpg";
	String androidName = "android.jpg";

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
	public void TC_01_Upload_Media() {
		mediaPage = (MediaPageObject) dashboardPage.clickToLessDynamicPageMenu(driver, "Media");
		mediaPage.clickToAddNewButton();
//		String a = "C:\\Users\\congh\\Desktop\\Automation\\Selenium_K14\\pom-wordpress-14-conghc\\uploadFiles\\android.jpg";
//		String b = "C:\\Users\\congh\\Desktop\\Automation\\Selenium_K14\\pom-wordpress-14-conghc\\uploadFiles\\ios.jpg";
//		mediaPage.sendkeyToElement(driver, AbstractPageUI.UPLOAD_FILE_TYPE, a + "\n" +b);
		mediaPage.uploadMultipleFiles(driver, iosName);
		// Verify file upload success
		Assert.assertTrue(mediaPage.areFileUploadedDisplay(driver, iosName));

	}

	@AfterTest
	public void afterClass() {
//		driver.quit();
	}

	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	PostsPageObject postsPage;
	MediaPageObject mediaPage;
	PagesPageObject pagesPage;
}
