package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.HomePageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomeMessageDisplayed() {
		return isElementDisplay(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
	}
	
}
