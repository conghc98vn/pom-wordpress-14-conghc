package pageObjects.wordpress.admin;

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

	public void clickToScreenOption() {
		waitForElementVissible(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
		sleepInSecond(2);
	}

	public boolean isActivityCheckboxDisplayed() {
		return isElementDisplay(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}

	public boolean isAllPostSubMenuDisplayed() {
		return isElementDisplay(driver, DashboardPageUI.ALL_POST_SUBMENU);
	}

	public boolean isPlanMenuDisplayed() {
		return isElementDisplay(driver, DashboardPageUI.PLANS_LINK);
	}

	public boolean isPlanMenuUndisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.PLANS_LINK);
	}

}
