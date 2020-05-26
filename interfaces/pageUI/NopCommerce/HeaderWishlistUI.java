package pageUI.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.HomePageUI;

public class HeaderWishlistUI extends AbstractPage{
	WebDriver driver;
	
	public HeaderWishlistUI(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomeMessageDisplayed() {
		return isElementDisplay(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
	}
	
}
