package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.HomePageUI;

public class WithdrawalPageObject extends AbstractPage{
	WebDriver driver;
	
	public WithdrawalPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
