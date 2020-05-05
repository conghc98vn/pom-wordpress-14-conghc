package commons;

import org.openqa.selenium.WebDriver;

import pageFactory.bankGuru.HomePageObject;
import pageFactory.bankGuru.LoginPageObject;
import pageFactory.bankGuru.RegisterPageObject;

public class PageGenenratorManager_PageFactory {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
