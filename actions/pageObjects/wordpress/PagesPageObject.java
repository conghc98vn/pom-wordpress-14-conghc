package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.MediaPageUI;
import pageUI.wordpress.PagesPageUI;

public class PagesPageObject extends AbstractPage{
	WebDriver driver;
	
	public PagesPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Pages Page = " + driver.toString());
	}
	
	public PagesPageObject clickToPagesMenu() {
		waitForElementInvissible(driver, PagesPageUI.PAGES_LINK);
		clickToElement(driver, PagesPageUI.PAGES_LINK);
		return PageGenenratorManager.getPagesPage(driver);
	}

	public MediaPageObject clickToMediaMenu() {
		waitForElementVissible(driver, MediaPageUI.MEDIA_LINK);
		clickToElement(driver, MediaPageUI.MEDIA_LINK);
		return PageGenenratorManager.getMediaPage(driver);
	}

}
