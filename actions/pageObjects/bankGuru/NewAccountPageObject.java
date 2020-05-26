package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.HomePageUI;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;
	
	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
