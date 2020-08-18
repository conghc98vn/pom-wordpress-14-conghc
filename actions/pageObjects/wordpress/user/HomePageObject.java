package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGenenratorManagerWordPress;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public PostDetailPageObject clickToPostDetailWithTitleName(String titleValue) {
		// TODO
		
		return PageGenenratorManagerWordPress.getPostDetailUserPage(driver);
		
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
