package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageUrl() {
		return getCurrentURL(driver);
	}

	public void clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inputToUserIDTextbox(String userIDValue) {
		waitForElementVissible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userIDValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVissible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
