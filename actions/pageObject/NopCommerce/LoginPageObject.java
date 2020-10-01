package pageObject.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.NopCommerce.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVissible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenenratorManager.getHomePage(driver);
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVissible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVissible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public String getEmailErrorMessage() {
		waitForElementVissible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_TEXT);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_TEXT);
	}

	public String getErrorMessageLogin() {
		waitForElementVissible(driver, LoginPageUI.EMAIL_AND_PASSWORD_ERROR_MESSAGE_LOGIN_TEXT);
		return getElementText(driver, LoginPageUI.EMAIL_AND_PASSWORD_ERROR_MESSAGE_LOGIN_TEXT);
	}
}
