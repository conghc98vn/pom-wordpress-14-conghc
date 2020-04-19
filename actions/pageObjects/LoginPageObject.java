package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVissible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToContinueOrLoginButton() {
		waitForElementVissible(driver, LoginPageUI.CONTINUE_OR_LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_OR_LOGIN_BUTTON);
	}

	public String getEmailOrPasswordErrorMessage() {
		waitForElementVissible(driver, LoginPageUI.EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVissible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getLoginPageUrl() {
		return getCurrentURL(driver);
	}

	public void openLoginPage(String url) {
		openUrl(driver, url);
	}

}
