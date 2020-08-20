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


}
