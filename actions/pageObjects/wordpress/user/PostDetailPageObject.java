package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.PostsDetailPageUI;

public class PostDetailPageObject extends AbstractPage{
	WebDriver driver;
	
	public PostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCategoryNameDisplayed(String newPostCategoryCheckbox) {
		waitForElementVissible(driver, PostsDetailPageUI.CATEGORY_NAME, newPostCategoryCheckbox);
		return isElementDisplay(driver, PostsDetailPageUI.CATEGORY_NAME, newPostCategoryCheckbox);
	}

	public boolean isTitleNameDisplayed(String newPostTitle) {
		waitForElementVissible(driver, PostsDetailPageUI.POST_TITLE_NAME, newPostTitle);
		return isElementDisplay(driver, PostsDetailPageUI.POST_TITLE_NAME, newPostTitle);
	}

	public boolean isImageNameDisplayed(String featureImageName) {
		String[] files = featureImageName.split("\\.");
		waitForElementVissible(driver, PostsDetailPageUI.POST_AVATAR_IMAGE, files);
		return isElementDisplay(driver, PostsDetailPageUI.POST_AVATAR_IMAGE, files);
	}

	public boolean isContentNameDisplayed(String newPostContent) {
		waitForElementVissible(driver, PostsDetailPageUI.POST_CONTENT_VALUE, newPostContent);
		return isElementDisplay(driver, PostsDetailPageUI.POST_CONTENT_VALUE, newPostContent);
	}
	
	public boolean isPostTagDisplay(String postTagName) {
		waitForElementVissible(driver, PostsDetailPageUI.POST_TAG_NAME, postTagName);
		return isElementDisplay(driver, PostsDetailPageUI.POST_TAG_NAME, postTagName);
	}

	public boolean isDateCreateDisplayed(String today) {
		waitForElementVissible(driver, PostsDetailPageUI.POST_DATE_CREATED, today);
		return isElementDisplay(driver, PostsDetailPageUI.POST_DATE_CREATED, today);
	}

	public boolean isAuthorDisplayed(String authorName) {
		waitForElementVissible(driver, PostsDetailPageUI.POST_AUTHOR_NAME, authorName);
		return isElementDisplay(driver, PostsDetailPageUI.POST_AUTHOR_NAME, authorName);
	}
}
