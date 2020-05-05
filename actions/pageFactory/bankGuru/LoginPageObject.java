package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, LoginPageObject.class);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='here']")
//	@FindBy(xpath = "//a[text()='here']")
	private WebElement hereLink;

	@FindBy(how = How.ID_OR_NAME, using = "uid")
	private WebElement userIDTextbox;

	@FindBy(how = How.ID_OR_NAME, using = "password")
	private WebElement passwordTextbox;

	@FindBy(how = How.ID_OR_NAME, using = "btnLogin")
	private WebElement loginButton;

	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

	public void clickToHereLink() {
		waitForElementClickable(driver, hereLink);
		clickToElement(driver, hereLink);
	}

	public void inputToUserIDTextbox(String userIDValue) {
		waitForElementVissible(driver, userIDTextbox);
		sendkeyToElement(driver, userIDTextbox, userIDValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVissible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, passwordValue);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}
}
