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

	public NewEditPostPageObject clickToPostDetailByTitleName(String string) {
		// TODO Auto-generated method stub
		return PageGenenratorManagerWordPress.getNewOrEditPostAdminPage(driver);
	}

	public NewEditPostPageObject clickToAddNewButton() {
		waitForElementClickable(driver, PostsPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, PostsPageUI.ADD_NEW_BUTTON);
		return PageGenenratorManagerWordPress.getNewOrEditPostAdminPage(driver);
	}

	public void inputToSearchTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSearchPostButton() {
		// TODO Auto-generated method stub
		
	}

	public boolean isOnlyOnceRowDisplayed(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isNoPostFoundMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
