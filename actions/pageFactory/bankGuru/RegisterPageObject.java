package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID_OR_NAME, using = "emailid")
	private WebElement emailTextbox;

	@FindBy(how = How.ID_OR_NAME, using = "btnLogin")
	private WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//td[text()='User ID :']/following-sibling::td")
	private WebElement userIDText;

	@FindBy(how = How.XPATH, using = "//td[text()='Password :']/following-sibling::td")
	private WebElement passwordText;

	public void inputToEmailTextbox(String email) {
		waitForElementVissible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, submitButton);
		clickToElement(driver, submitButton);
	}

	public String getUserIDText() {
		waitForElementVissible(driver, userIDText);
		return getElementText(driver, userIDText);
	}

	public String getPasswordText() {
		waitForElementVissible(driver, passwordText);
		return getElementText(driver, passwordText);
	}

	public void openLoginPage(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
	}
}
