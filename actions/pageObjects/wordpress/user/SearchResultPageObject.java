package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class SearchResultPageObject extends AbstractPage{
	WebDriver driver;
	
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNewPostDisplayedLatestPost(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPostImageDisplayedAtPostTitleName(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}
}
