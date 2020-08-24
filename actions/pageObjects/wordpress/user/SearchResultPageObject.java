package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.SearchResultPageUI;

public class SearchResultPageObject extends AbstractPage {
	WebDriver driver;

	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayedOnHeader(String newPostTitle) {
		waitForElementVissible(driver, SearchResultPageUI.POST_TITLE_ON_HEADER, newPostTitle);
		return isElementDisplay(driver, SearchResultPageUI.POST_TITLE_ON_HEADER, newPostTitle);
	}
}
