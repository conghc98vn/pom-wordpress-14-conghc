package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Dashboard Page = " + driver.toString());
	}

	public boolean isHeaderTextDisplayed() {
		waitForElementVissible(driver, DashboardPageUI.HEADER_TEXT);
		return isElementDisplay(driver, DashboardPageUI.HEADER_TEXT);
	}

}
