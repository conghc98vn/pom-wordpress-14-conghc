package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.PagesPageUI;
import pageUI.wordpress.PostsPageUI;

public class PostsPageObject extends AbstractPage{
	WebDriver driver;
	
	public PostsPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Posts Page = " + driver.toString());
	}
	
	
	public PostsPageObject clickToPostsMenu() {
		waitForElementVissible(driver, PostsPageUI.POSTS_LINK);
		clickToElement(driver, PostsPageUI.POSTS_LINK);
		return PageGenenratorManager.getPostsPage(driver);
	}

	public PagesPageObject clickToPagesMenu() {
		waitForElementInvissible(driver, PagesPageUI.PAGES_LINK);
		clickToElement(driver, PagesPageUI.PAGES_LINK);
		return PageGenenratorManager.getPagesPage(driver);
	}
}
