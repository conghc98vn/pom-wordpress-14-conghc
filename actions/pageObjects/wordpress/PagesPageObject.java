package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PagesPageObject extends AbstractPage {
	WebDriver driver;

	public PagesPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Pages Page = " + driver.toString());
	}

}
