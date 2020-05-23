package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.MediaPageUI;

public class MediaPageObject extends AbstractPage{
	WebDriver driver;
	
	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Media Page = " + driver.toString());
	}
	
	public MediaPageObject clickToMediaMenu(WebDriver driver) {
		waitForElementVissible(driver, MediaPageUI.MEDIA_LINK);
		clickToElement(driver, MediaPageUI.MEDIA_LINK);
		return PageGenenratorManager.getMediaPage(driver);
	}
}
