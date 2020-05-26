package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.HomePageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;
	
	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
