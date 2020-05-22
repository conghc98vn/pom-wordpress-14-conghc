package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CommentPageObject extends AbstractPage{
	WebDriver driver;
	
	public CommentPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
