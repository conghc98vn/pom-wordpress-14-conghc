package pageFactory.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHeaderTextDisplayed() {
		waitForElementVissible(driver, DashboardPageUI.HEADER_TEXT);
		return isElementDisplay(driver, DashboardPageUI.HEADER_TEXT);
	}

	public void clickToPostsMenu() {
		// TODO Auto-generated method stub
		
	}
}
