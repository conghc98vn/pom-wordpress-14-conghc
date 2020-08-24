package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGenenratorManagerWordPress;
import pageUI.wordpress.admin.PostsPageUI;

public class PostsPageObject extends AbstractPage {
	WebDriver driver;

	public PostsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public NewEditPostPageObject clickToPostDetailByTitleName(String titleName) {
		waitForElementClickable(driver, PostsPageUI.POST_TITLE_LINK, titleName);
		clickToElement(driver, PostsPageUI.POST_TITLE_LINK, titleName);
		return PageGenenratorManagerWordPress.getNewOrEditPostAdminPage(driver);
	}

	public NewEditPostPageObject clickToAddNewButton() {
		waitForElementClickable(driver, PostsPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, PostsPageUI.ADD_NEW_BUTTON);
		return PageGenenratorManagerWordPress.getNewOrEditPostAdminPage(driver);
	}

	public void inputToSearchTextbox(String postTitle) {
		waitForElementsVissible(driver, PostsPageUI.SEARCH_POST_TEXTBOX);
		sendkeyToElement(driver, PostsPageUI.SEARCH_POST_TEXTBOX, postTitle);
	}

	public void clickToSearchPostButton() {
		waitForElementsVissible(driver, PostsPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, PostsPageUI.SEARCH_POST_BUTTON);
	}

	public boolean isNoPostFoundMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
