package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MediaPageObject extends AbstractPage {
	WebDriver driver;

	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Media Page = " + driver.toString());
	}
}
