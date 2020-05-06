package pageFactory.wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "usernameOrEmail")
	private WebElement emailTextbox;

	@FindBy(id = "password")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//div[@class='login__form-action']/button")
	private WebElement continueOrLoginButton;

	@FindBy(xpath = "//div[@class='form-input-validation is-error']/span")
	private WebElement emailOrPasswordErrorMessage;

	public void inputToEmailTextbox(String email) {
		waitForElementVissible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVissible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void clickToContinueOrLoginButton() {
		waitForElementVissible(driver, continueOrLoginButton);
		clickToElement(driver, continueOrLoginButton);
	}

	public String getEmailOrPasswordErrorMessage() {
		waitForElementVissible(driver, emailOrPasswordErrorMessage);
		return getElementText(driver, emailOrPasswordErrorMessage);
	}

	public String getLoginPageUrl() {
		return getCurrentURL(driver);
	}

	public void openLoginPage(String url) {
		openUrl(driver, url);
	}

}
