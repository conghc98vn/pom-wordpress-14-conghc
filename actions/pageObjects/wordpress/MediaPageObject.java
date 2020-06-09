package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.MediaPageUI;

public class MediaPageObject extends AbstractPage {
	WebDriver driver;

	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Media Page = " + driver.toString());
	}

	public void clickToAddNewButton() {
		waitForElementVissible(driver, MediaPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MediaPageUI.ADD_NEW_BUTTON);
	}

}
