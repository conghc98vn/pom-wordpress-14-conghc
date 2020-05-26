package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PostsPageObject extends AbstractPage {
	WebDriver driver;

	public PostsPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Posts Page = " + driver.toString());
	}
}
