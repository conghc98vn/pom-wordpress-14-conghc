package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.DashboardPageUI;
import pageUI.wordpress.PostsPageUI;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Dashboard Page 1= " + driver.toString());
	}
	
	public boolean isHeaderTextDisplayed() {
		waitForElementVissible(driver, DashboardPageUI.HEADER_TEXT);
		return isElementDisplay(driver, DashboardPageUI.HEADER_TEXT);
	}

	public PostsPageObject clickToPostsMenu() {
		waitForElementVissible(driver, PostsPageUI.POSTS_LINK);
		clickToElement(driver, PostsPageUI.POSTS_LINK);
		return PageGenenratorManager.getPostsPage(driver);
	}

}
