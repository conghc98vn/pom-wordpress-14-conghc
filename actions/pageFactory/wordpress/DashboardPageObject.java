package pageFactory.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.DashboardPageIUI;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHeaderTextDisplayed() {
		waitForElementVissible(driver, DashboardPageIUI.HEADER_TEXT);
		return isElementDisplay(driver, DashboardPageIUI.HEADER_TEXT);
	}

	
	public static final String HEADER_TEXT = "//h1[text()='Dashboard']";
}
